package com.demo1.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Yuan
 * @description MapperFactoryBean
 * @date 2022/9/6
 */
public class MapperFactoryBean implements FactoryBean {

	private Class<?> mapperInterface;

	private SqlSession sqlSession;

	public MapperFactoryBean(Class<?> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		return sqlSession.getMapper(mapperInterface);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
		this.sqlSession = sqlSessionFactory.openSession();
	}
}
