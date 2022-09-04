package com.demo3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author Yuan
 * @description BeanB
 * @date 2022/9/4
 */
@Scope(scopeName = "myScope",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanB {
}
