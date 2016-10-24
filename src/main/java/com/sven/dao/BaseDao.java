package com.sven.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/** 连接db流程：
 * 在SqlSessionDaoSupport 自动装配 sqlSessionFactory 只要在 applicationContext.xml配了这个bean
 * 就会连上这个bean对应的数据源
 * 在BaseDao可以作一些重载或新方法
 * Created by sven on 2016/10/21.
 */
public class BaseDao extends SqlSessionDaoSupport {
}
