package com.mzz.microservice.controller;

import com.mzz.microservice.entities.Dept;
import com.mzz.microservice.services.impl.DeptServiceImp;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptServiceImp deptServiceImp;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Options(useGeneratedKeys = true,keyProperty = "deptNo")
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        System.out.println("8003");
        return deptServiceImp.add(dept);}

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        System.out.println("8003");
        return deptServiceImp.get(id);
    }

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list()
    {
        System.out.println("8003");return deptServiceImp.list();
    }


    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery()
    {
        System.out.println("8003");
        List<String> list=discoveryClient.getServices();
        System.out.println("**************"+list);
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("MICROSERVICECLOUD-DEPT3");//寻找叫做"MICRESERVICECLOUD-DEPT"的服务
        for(ServiceInstance serviceInstance:serviceInstances)
        {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
