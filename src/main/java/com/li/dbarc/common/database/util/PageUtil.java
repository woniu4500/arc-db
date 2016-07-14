package com.li.dbarc.common.database.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.li.dbarc.common.database.Page;
import com.li.dbarc.common.database.Pagination;
import com.li.dbarc.common.database.Sort;
import com.li.dbarc.common.database.criteria.BeanColumnMap;

/**
 * The Class PageUtil.
 *
 * @author 
 * @since 2013-12-19 15:37:18
 * @version 1.0.0
 */
public final class PageUtil {
	
	/** 常量  DEF_LIMIT. */
	public static final Long DEF_LIMIT = 20l;
	
	/** 常量  DEF_START. */
	public static final Long DEF_START = 0l;
	
	/** 升序排列. */
	public static final String DIR_ASC = "ASC";
	
	/** 降序排列. */
	public static final String DIR_DESC = "DESC";
	
	/** 默认排序为升序. */
	public static final String DEF_DIR = DIR_ASC;
	
	private PageUtil(){
		
	}
	
	/**
	 * 生成排序信息.
	 *
	 * @param page the page
	 * @param columnMap the column map
	 * @return the list
	 */
	public static List<Sort> genSorts(Page page, Map<String, BeanColumnMap> columnMap) {
		if ( page == null || columnMap == null ) {
			return null ; 
		}
		String sort = StringUtils.trimToEmpty(page.getSort());
		String dir  = StringUtils.trimToEmpty(page.getDir());
		String[] sorts = sort.split(",");
		String[] dirs = dir.split(",");
		int dirsize = dirs.length ; 
		List<Sort> sortList = new ArrayList<Sort>();
		for (int i = 0 ; i < sorts.length ; i++ ) {
			String fld = sorts[i];
			BeanColumnMap column = columnMap.get(fld.trim().toLowerCase());
			if ( column == null ) {
				continue ; 
			}
			String columnName = column.getColumnName();
			String dirType = DEF_DIR;
			if ( dirsize > i && DIR_DESC.equalsIgnoreCase(dirs[i])) {
				dirType = DIR_DESC ;
			}
			sortList.add(new Sort(columnName, dirType));
		}
		if ( sortList.size() == 0) {
			return null ;
		}
		return sortList ; 
	}
	
	/**
	 * 生成分页参数.
	 *
	 * @param page the page
	 * @return the pagination
	 */
	public static Pagination genPagination(Page page ){
		if ( page == null ) {
			return new Pagination(DEF_LIMIT, DEF_START);
		}
		String limit = page.getLimit();
		String start = page.getStart();
		if (limit!=null && Page.FOR_EXPORT.equals(limit.trim()) ) {
			return new Pagination(-1l, DEF_START);
		}
		Pagination pg = new Pagination(DEF_LIMIT, DEF_START);
		if ( NumberUtils.isNumber(limit)) {
			pg.setLimit(Long.valueOf(limit));
		}
		if ( NumberUtils.isNumber(start)) {
			pg.setOffset(Long.valueOf(start));
		}
		return pg ; 
	}
	/**
	 * 获得分页信息(导出报表Excel用的)。.
	 * 
	 * @return 分页信息
	 */
	public Page getExcelPageInfo() {
		Page page = getPageInfo();
		page.setLimit("excel");
		return page;
	}
	/**
	 * 获得分页信息。.
	 * 
	 * @return 分页信息
	 */
	public static Page getPageInfo() {
		Page page = new Page();
		page.setDir("ASC");
		page.setLimit("excel");
		page.setSort("loanId");
		page.setStart("0");
		return page;
	}
}
