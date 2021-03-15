package cn.tedu.mybatis1;

import cn.tedu.mybatis1.mapper.DemoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class Mybatis1ApplicationTests {
    @Resource
    private DemoMapper demoMapper;
    @Test
    void contextLoads() {
        String str=demoMapper.hello();
        log.debug(str);
    }
    @Test
    void demo(){
        String str=demoMapper.demo();
        log.debug("{}",str);
    }



}
