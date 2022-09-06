package com.demo1.config;

import com.demo1.mybatis.MapperScan;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yuan
 * @description AppConfig
 * @date 2022/9/6
 */
@Configuration
@ComponentScan("com.demo1")
@MapperScan("com.demo1.mapper")
public class AppConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

}
