package com.mzz.microservice.controller;

import com.mzz.microservice.entities.Dept;
import com.mzz.microservice.services.DeptClientService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControllerFeignConsumer {

    @Autowired
    private DeptClientService deptClientService;//客户端实现Hystrix的服务熔断机制
    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id)
    {
        return deptClientService.get(id);
    }
    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list()
    {
        return deptClientService.list();
    }
    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept)
    {
        return deptClientService.add(dept);
    }
}