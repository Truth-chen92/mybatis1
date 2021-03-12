package cn.tedu.mybatis1.mapper;

import cn.tedu.mybatis1.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Employee 的数据访问接口
 */
public interface EmployeeMapper {
    /**
     * 根据ID查询一个员工数据
     * #{empNo} 是MyBatis的参数占位符
     * 在查询的时候MyBatis会读取方法参数
     * 作为占位的参数传输到数据库执行SQL
     *
     */
//    @Select("SELECT * FROM emp WHERE EMPNO=#{empNo}")
    @Select({"SELECT","empNo,","ename as name,","job,",
            "mgr,","hiredate,","mgr,","sal as salary,","comm,","deptno","FROM emp WHERE EMPNO=#{empNo}"})
    Employee getEmployeeById(Integer empNo);
    /**
     * 将全部员工信息查询出来
     */
    @Select({"SELECT","empNo,","ename as name,","job,",
            "mgr,","hiredate,","mgr,","sal as salary,","comm,","deptno","FROM emp"})
    List<Employee>getAllEmployee();
    /**
     * 利用MyBatis将员工数据插入到数据中
     * INSERT INTO emp
     * (EMPNO, ENAME, JOB, MGR, HIREdate, SAL, COMM, DEPTNO)
     * values
     * (null,'TOM','CODING',0,now(),1000.0,100.0,1);
     */
    @Insert({"INSERT INTO emp",
            "(EMPNO, ENAME, JOB, MGR, HIREdate, SAL, COMM, DEPTNO)",
            "VALUES",
            "(null,#{name},#{job},#{mgr},#{hiredate},#{salary},#{comm},#{deptNo})"})
    Integer saveEmployee(Employee employee);
    /**
     * 根据ID更新一个员工的全部信息
     * UPDATE emp
     * SET ENAME=?,JOB=?,MGR=?,HIREdate=?,SAL=?,COMM=?,DEPTNO=?
     * WHERE EMPNO=?;
     * MyBatis的Mapper方法 如果执行的是INSERT UPDATE DELETE
     * 则可以返回一个整数结果 为插入/更新/删除的行数
     */
    @Update({"UPDATE emp",
            "SET ENAME=#{name},JOB=#{job},MGR=#{mgr},HIREdate=#{hiredate},",
    "SAL=#{salary},COMM=#{comm},DEPTNO=#{deptNo}",
    "WHERE EMPNO=#{empNo}"})
    Integer updateEmployee(Employee employee);
    /**
     * 删除一行数据
     * DELETE FROM emp WHERE EMPNO=?
     */
    @Delete("DELETE FROM emp WHERE EMPNO=#{empNo}")
    Integer deleteEmployeeById(Integer empNo);
}
