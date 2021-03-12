package cn.tedu.mybatis1.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 员工类
 */
@Data
@Accessors(chain = true)
public class Employee implements Serializable {
    private Integer empNo;
    private String name;
    private String job;
    private Integer mgr;
    //java8 提供的日期类型
    private LocalDate hiredate;
    private Double salary;
    private Double comm;
    private Integer deptNo;
}
