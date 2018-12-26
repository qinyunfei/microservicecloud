package com.qin.wcc.controller;

import com.qin.wcc.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller_Consumer {
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;



    @PostMapping("/dept/add")
    public int add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,int.class);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }


    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
