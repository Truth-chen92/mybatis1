package cn.tedu.mybatis1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan 是MyBatis提供的注解 标注在spring配置类上
 * spring 启动时就会自动扫描指定包和子包
 * 将实现包中mapper接口 并且创建mapper接口的匿名实现类
 */
@SpringBootApplication
@MapperScan("cn.tedu.mybatis1.mapper")
public class Mybatis1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis1Application.class, args);
    }

}
