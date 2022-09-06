package com.demo1.mapper;

import com.demo1.mybatis.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Yuan
 * @description UserMapper
 * @date 2022/9/6
 */
@Mapper
public interface UserMapper {

	@Select("select '李四'")
	String selectName();
}
