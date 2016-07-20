package com.li.dbarc.common.database;

import java.util.HashMap;
import java.util.Map;

 /**
 * @version  1.0
 *
 * @author   WHQ
 *
 * @date     2015-11-06
 *
 * @description	 分页数据对象
 */

public class PaginationData {
	
	/** 每页显示数据条数 */
	private int pageSize = 10;
	
	/** 分页总页数 */
	private int pageNum = 0;
	
	/** 数据总量 */
	private int dataNum = 0;
	
	/** 当前页数 */
	private int curPage = 0;
	
	/** 分页查询参数 */
	private Map<String,String> param = new HashMap<String,String>();

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getDataNum() {
		return dataNum;
	}

	public void setDataNum(int dataNum) {
		this.dataNum = dataNum;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}
}