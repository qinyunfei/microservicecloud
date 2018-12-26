package com.qin.wcc.controller;

import com.qin.wcc.entities.Dept;
import com.qin.wcc.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller_Consumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }
}
