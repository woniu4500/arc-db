/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.li.dbarc.common.database.support;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

public abstract class SqlSessionDaoSupport extends DaoSupport {
	private SqlSession sqlSession;
	private boolean externalSqlSession;
	
	@Autowired(required=false) 
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (!(this.externalSqlSession))
			this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
	}

	@Autowired(required=false) 
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSession = sqlSessionTemplate;
		this.externalSqlSession = true;
	}

	public SqlSession getSqlSession() {
		return this.sqlSession;
	}

	protected void checkDaoConfig() {
		Assert.notNull(this.sqlSession,
				"Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
	}
}