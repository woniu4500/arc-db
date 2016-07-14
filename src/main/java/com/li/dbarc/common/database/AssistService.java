package com.li.dbarc.common.database;

import com.li.dbarc.common.database.assist.QueryAssist;


/**
 * The Class AssistService.
 * 查询操作辅助
 * 
 * @company Shanghai JinYu Software Systems CO.,LTD.
 * @author 
 * @since 2014-1-3 14:07:07
 * @version 1.0.0
 */
public abstract class AssistService {

	/** The Query assist query assist. */
	private QueryAssist queryAssist ;

	/**
	 * Gets the query assist.
	 *
	 * @return the queryAssist
	 */
	public QueryAssist getQueryAssist() {
		return queryAssist;
	}

	/**
	 * Sets the query assist.
	 *
	 * @param queryAssist the queryAssist to set
	 */
	public void setQueryAssist(QueryAssist queryAssist) {
		this.queryAssist = queryAssist;
	} 
	
}
