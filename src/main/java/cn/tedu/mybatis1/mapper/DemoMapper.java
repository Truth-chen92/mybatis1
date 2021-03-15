package cn.tedu.mybatis1.mapper;

import org.apache.ibatis.annotations.Select;

public interface DemoMapper {
    /**
     * 执行hello方法时 MyBatis会自动执行查询语句
     * 并且SQL查询结果作为方法返回结果
     * @return
     */
    @Select("select 'Hello World!'")
    String hello();
    /**
     * 测试利用XML文件将SQL映射到demo方法
     */
    String demo();

    Integer deleteAllEmployee(int... n);
}
