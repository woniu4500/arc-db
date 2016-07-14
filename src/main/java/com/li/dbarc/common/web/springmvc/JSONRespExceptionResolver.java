package com.li.dbarc.common.web.springmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.li.dbarc.common.database.ExtData;
import com.li.dbarc.common.database.exception.BaseException;
import com.li.dbarc.common.database.util.ExtDataUtil;

/**
 * <h1>The Class JSONRespExceptionResolver.</h1>
 * <p>Descriptions:</p>
 *
 * @company Shanghai JinYu Software Systems CO.,LTD.
 * @author
 * @since 2014
 * @version 1.0.0
 */
public class JSONRespExceptionResolver implements HandlerExceptionResolver {
	/**
	 * Logger for this class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONRespExceptionResolver.class);

	public static final String DEF_STRING = "{\"success\":false, \"syserr\": \"error.unkown.exception\"}";
	
	/**
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@SuppressWarnings("rawtypes")
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		LOGGER.error("请求出错：", ex);
		ExtData data = null;
		if ( ex instanceof BaseException ) {
			data = ExtDataUtil.genWithExceptions(ex);
		} else if ( ex instanceof SQLException || ex instanceof DataAccessException ) {
			data = ExtDataUtil.genWithExceptions("error.sql.exception");
		} else {
			data = ExtDataUtil.genWithExceptions("error.unkown.exception");
		}
		// global message
		RequestContext requestContext = new RequestContext(request);
//		data.setRespinfo(requestContext.getMessage(data.getRespinfo(), data.getRespinfo()));
		data.setResp_info(requestContext.getMessage(data.getResp_info(),data.getResp_info()));
		Map<String, Object> model = new HashMap<String, Object>(); 
//      model.put("data", StringUtils.defaultIfEmpty(data.getRespinfo(), DEF_STRING));
		model.put("data", StringUtils.defaultIfEmpty(data.getResp_info(), DEF_STRING));
        LOGGER.info("Error Info：", model.get("data"));
		return new ModelAndView("error/exception.html", model);
	}

}
