package com.mzz.microservice.services.impl;
import com.mzz.microservice.dao.DeptDao;
import com.mzz.microservice.entities.Dept;
import com.mzz.microservice.services.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service//对dao层的更一步封装
public class DeptServiceImp implements IDeptService {

    @Autowired
    private DeptDao deptDao;
    public boolean add(Dept dept) { return deptDao.addDept(dept); }
    public Dept get(Long id) {
        return deptDao.getDeptById(id);
    }
    public List<Dept> list() {
        return deptDao.getAllDepts();
    }
}
