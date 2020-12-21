package com.mzz.microservice.controller;

import com.mzz.microservice.entities.Dept;
import com.mzz.microservice.services.impl.DeptServiceImp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
        System.out.println("8004");

        return deptServiceImp.add(dept);}

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_GET")
    public Dept get(@PathVariable("id") Long id)
    {
        System.out.println("8004");
        Dept dept=deptServiceImp.get(id);
        if(dept==null)
        {
            throw new RuntimeException("该ID："+id+"没有对应的信息");
        }
        return dept;
    }
    public Dept processHystrix_GET(@PathVariable("id") Long id)
    {
        return new Dept().setDeptNo(id).setDeptName("该ID："+id+"没有对应的信息，null--@HystrixCommand").setDbSource("no this database in MYSQL");
    }

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list()
    {
        System.out.println("8004");return deptServiceImp.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery()
    {
        System.out.println("8004");
        List<String> list=discoveryClient.getServices();
        System.out.println("**************"+list);
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("MICROSERVICECLOUD-DEPT1");//寻找叫做"MICRESERVICECLOUD-DEPT"的服务
        for(ServiceInstance serviceInstance:serviceInstances)
        {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
