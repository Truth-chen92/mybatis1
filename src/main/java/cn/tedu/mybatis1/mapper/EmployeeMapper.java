package cn.tedu.mybatis1.mapper;

import cn.tedu.mybatis1.entity.Employee;
import cn.tedu.mybatis1.vo.EmployeeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Employee 的数据访问接口
 */
public interface EmployeeMapper{
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
    /**
     * Options:选项
     * Generated:生成的
     * Keys:关键字
     * keyProperty:关键字属性 就是实体类中的ID
     * 标注了@Options可以与@Insert配合获取自动生成的Key
     * keyProperty = "empNo" 是Employee的属性
     */
    @Options(useGeneratedKeys = true,keyProperty = "empNo")
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
    /**
     * 查询薪资2000-2200之间的员工
     * SELECT * FROM emp WHERE SAL BETWEEN ? AND ?
     */
    @Select({"SELECT","empNo,","ename as name,","job,",
            "mgr,","hiredate,","mgr,","sal as salary,",
            "comm,","deptno","FROM emp WHERE SAL BETWEEN #{min} AND #{max}",
            "ORDER BY SAL DESC"})
    List<Employee> getEmployBySalary(
            @Param("min") Double min, @Param("max") Double max);
    /**
     * 关于参数名称：
     * 1.Java8之前Java编译以后 在字节码文件中不保留方法参数变量名
     *   为了处理多个参数变量 MyBatis提供了一个注解 @Param("")作用就是给参数
     *   方法参数变量一个名称 用于SQL语句参数绑定
     * 2.Java8以后springboot 在maven插件中开启了保留Java方法参数名到字节码文件的功能
     *  Java8+springboot时 可以不用使用@param
     * 3.利用阿里云脚手架创建的springboot项目 没有打开这个开关 按照1进行编译
     */
    /**
     * 删除一组员工对象
     */
    Integer deleteAllEmployee(Integer... empNumbers);
    /**
     * ${columnName}进行SQL语句拼接
     * #{empNo} 进行SQL参数传递
     */
    @Select("SELECT ${columnName} FROM emp WHERE empNo=#{empNo}")
    String getName(String columnName,Integer empNo);
    /**
     * 动态更新属性方法 可以更改部分属性值
     * 参数中必须设定 employeeId属性
     * 设置需要更改的属性值 不需要更改的保存null
     * 更新时候 会自动将属性值更新到数据库
     */
    Integer updateEmployeeInfo(Employee employee);

    /**
     * SELECT EMPNO,ENAME,DNAME
     * FROM emp e
     * left join dept d on e.DEPTNO = d.DEPTNO
     * where dname='java'
     * 利用值对象封装关联查询结果 值对象是为了针对当前查询定义的对象 专门封装当前查询的返回值
     * @return
     */
    @Select({"SELECT","EMPNO,","ENAME AS name,","DNAME AS department","FROM emp e",
            "LEFT JOIN dept d on e.DEPTNO =d.DEPTNO","WHERE DNAME=#{dname}"})
    List<EmployeeVO> getEmployeeInfo(String dname);

}
