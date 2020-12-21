package com.mzz.microservice.dao;
import com.mzz.microservice.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept getDeptById(Long id);
    List<Dept> getAllDepts();
}
