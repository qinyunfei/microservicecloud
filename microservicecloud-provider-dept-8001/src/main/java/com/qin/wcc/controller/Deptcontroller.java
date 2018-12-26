package com.qin.wcc.controller;

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

    @PostMapping("/dept/add")
    public int add(Dept dept){
        return deptService.insertSelective(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        return deptService.selectByPrimaryKey(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(Dept dept){
        return deptService.selectAll();
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
