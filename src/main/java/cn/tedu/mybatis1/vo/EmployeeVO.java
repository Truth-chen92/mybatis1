package cn.tedu.mybatis1.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeVO {
    /**员工号*/
    private Integer empNo;
    /**员工名*/
    private String name;
    /**部门名*/
    private String department;
}
