package com.mzz.microservice.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable
{
    private Long deptNo;
    private String deptName;
    private String dbSource;

    public Dept(String deptName)
    {
        this.deptName=deptName;
    }
}

