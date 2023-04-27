package com.ssafy.book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//예전 root-context.xml이나 servlet-context.xml 같이 객체관리 해주는 자바버전
@Configuration
@MapperScan("com.ssafy.book.model.dao") //인터페이스 매퍼스캔 
public class DBConfig {
}
