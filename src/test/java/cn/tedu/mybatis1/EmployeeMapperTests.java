package cn.tedu.mybatis1;

import cn.tedu.mybatis1.entity.Employee;
import cn.tedu.mybatis1.mapper.DemoMapper;
import cn.tedu.mybatis1.mapper.EmployeeMapper;
import cn.tedu.mybatis1.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
public class EmployeeMapperTests {
    @Resource
    EmployeeMapper mapper;
    @Test
    void getEmployeeById(){
        Employee employee=mapper.getEmployeeById(1);
        log.debug("{}",employee);
    }
    @Test
    void getAllEmployees(){
        List<Employee>list = mapper.getAllEmployee();
        list.forEach(e->log.debug("{}", e));
    }
    @Test
    void saveEmployee(){
        Employee employee = new Employee().setName("JERRY")
                .setJob("玩猫").setSalary(2000.0).setComm(200.0)
                .setHiredate(LocalDate.now()).setDeptNo(1).setMgr(0);
        Integer n=mapper.saveEmployee(employee);
        log.debug("添加数:{}",n);
    }
    @Test
    void updateEmployee(){
        Employee employee = new Employee().setName("CANG").setJob("演员")
                .setMgr(1).setSalary(500.0).setComm(25.0).setHiredate(LocalDate.now())
                .setDeptNo(3).setEmpNo(1);
        Integer n=mapper.updateEmployee(employee);
        log.debug("更新数：{}",n);
    }
    @Test
    void deleteEmployee(){
        Integer n = mapper.deleteEmployeeById(2);
        log.debug("删除数：{}",n);

    }
    @Test
    void addData(){
        Employee employee = new Employee().setName("光头强")
                .setJob("砍树").setSalary(2100.0).setComm(10.0)
                .setHiredate(LocalDate.now()).setDeptNo(1).setMgr(0);
        Integer n=mapper.saveEmployee(employee);
        employee = new Employee().setName("熊大")
                .setJob("吃香蕉").setSalary(200.0).setComm(20.0)
                .setHiredate(LocalDate.now()).setDeptNo(1).setMgr(0);
        n=mapper.saveEmployee(employee);
        employee = new Employee().setName("高永辉")
                .setJob("睡觉").setSalary(200.0).setComm(20.0)
                .setHiredate(LocalDate.now()).setDeptNo(1).setMgr(0);
        n=mapper.saveEmployee(employee);
        log.debug("行数：{}",n);
    }
    @Test
    void getEmployBySalary(){
        List<Employee>list = mapper.getEmployBySalary(200.0,2200.0);
        list.forEach(e->log.debug("{}",e));
    }
    @Test
    void saveAuto(){
        Employee employee = new Employee().setName("叶其杰")
                .setJob("聊QQ").setSalary(1500.0).setComm(100.0)
                .setHiredate(LocalDate.now()).setDeptNo(1).setMgr(0);
        Integer n=mapper.saveEmployee(employee);
        log.debug("添加行数:{}", n);
        log.debug("添加成功:{}",employee);
    }
    @Test
    void deleteAllEmployee(){
        Integer n= mapper.deleteAllEmployee(7,8,9);
        log.debug("{}", n);
    }
    @Test
    void getName(){
        String s=mapper.getName("ename",4);
        log.debug("{}",s);
        String s2=mapper.getName("job",6);
        log.debug("{}", s2);
    }
    @Test
    void updateEmployeeInfo(){
        Employee employee=new Employee().setEmpNo(4).setJob("霸王").setName("小小");
        Integer n=mapper.updateEmployeeInfo(employee);
        log.debug("{}", n);
    }
    @Test
    void a(){
        List<EmployeeVO> list = mapper.getEmployeeInfo("java");
        list.forEach(e->log.debug("{}",e));
    }
}
