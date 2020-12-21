package com.mzz.microservice.services;

import com.mzz.microservice.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept get(long id) {
                return new Dept().setDeptNo(id).setDeptName("该ID："+id+"没有对应的信息，consumer客户端提供降级信息，刺客服务provider已经关闭").setDbSource("no that database in mysql");
            }

            public List<Dept> list() {
                return null;
            }

            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
