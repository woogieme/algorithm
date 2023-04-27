package com.ssafy.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ssafy.test.model.dao")
public class DBConfig {

}
