package com.demo1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yuan
 * @description UserMapper
 * @date 2022/9/15
 */
@Mapper
public interface UserMapper {

	@Insert("insert into user (name) values (#{name})")
	void insert(String name);

}
