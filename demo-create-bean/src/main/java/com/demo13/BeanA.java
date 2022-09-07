package com.demo13;

import javax.annotation.PreDestroy;

/**
 * @author Yuan
 * @description BeanA
 * @date 2022/9/7
 */
public class BeanA  {

	@PreDestroy
	public void off(){
		System.out.println("off");
	}


	public void close() throws Exception {
		System.out.println("close");
	}

	public void end(){
		System.out.println("end");
	}


	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	public void shutdown() throws Exception {
		System.out.println("shutdown");
	}
}
