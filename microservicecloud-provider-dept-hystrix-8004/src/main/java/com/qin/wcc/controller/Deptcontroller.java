package com.qin.wcc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qin.wcc.entities.Dept;
import com.qin.wcc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Deptcontroller {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;


    @GetMapping("/dept/get/{id}")
//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) throws InterruptedException {
        //Thread.sleep(10000);
        Dept dept = this.deptService.selectByPrimaryKey(id);

        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
