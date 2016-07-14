package com.li.dbarc.common;

/**
 * The Interface ErrorCode.
 * 
 * @company Shanghai JinYu Software Systems CO.,LTD.
 * @author 
 * @since 2014-1-3 10:32:29
 * @version 1.0.0
 */
public interface SystemErrorCode {
	
	// 99__:系统\框架错误信息
	/** CODE:9901 */
	String CODE_9901 = "9901";
	/** MSG:页面对象获取失败 */
	String CODE_9901_MSG = "页面对象获取失败";
	
	/** CODE:9902 */
	String CODE_9902 = "9902";
	/** MSG:数据库插入单条记录失败. */
	String CODE_9902_MSG = "数据库插入单条记录失败";
	/** MSG:数据库更新单条记录失败. */
	String CODE_9902_MSG_1 = "数据库更新单条记录失败";
	/** MSG:数据更新失败，请重新加载页面后继续操作*/
	String CODE_9902_MSG_2 = "数据更新失败，请重新加载页面后继续操作";
	/** CODE:9903 格式转换错误 */
	String CODE_9903 = "9903";
}
