package com.li.dbarc.common.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.li.dbarc.common.database.exception.BaseException;

public class JSONUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(JSONUtil.class);

	/** Global Object Mapper */
	private static final ObjectMapper MAPPER = new ObjectMapper();

	static {
		MAPPER.setSerializationInclusion(Inclusion.NON_NULL); 
	}
	
	/**
	 * 转换成JSON字符串, 转换出错时返回空串
	 * 
	 * @param value  待转换对象
	 * @return json字符串
	 * @throws JsonGenerationException 
	 * @throws JsonMappingException 
	 */
	public static String convertToJson(Object value) {
		try {
			return MAPPER.writeValueAsString(value);
		} catch (IOException e) {
			LOGGER.error("Error convert Object to json. ", e);
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 从字符串中获取对象 request.getParameter(paramName)
	 * 
	 * @param <T> the generic type
	 * @param jsonObjectStr the json object str
	 * @param targetClass  目标类型
	 * @return the T
	 * @throws JsonParseException 
	 * @throws JsonMappingException 
	 */
	public static <T> T objectFromString(String jsonObjectStr,
			Class<T> targetClass) throws JsonParseException, JsonMappingException {
		MAPPER.setVisibility(JsonMethod.FIELD, Visibility.ANY);
		MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// Empty check
		if (StringUtils.isNotBlank(jsonObjectStr)) {
			try {
				return MAPPER.readValue(jsonObjectStr, targetClass);
			} catch ( JsonParseException jpe) {
				throw jpe;
			} catch ( JsonMappingException jme) {
				throw jme;
			} catch (IOException e) {
				LOGGER.error("Error read Object from json. ", e);
			}
		}
		// Return null when input string is blank.
		return null;
	}

	/**
	 * 从字符串转换为目标列表.
	 * 
	 * @param <T> the generic type
	 * @param jsonArrayStr 待转换字符串
	 * @param targetClass  目标类型
	 * @return the list< t>
	 * @throws JsonParseException 
	 * @throws JsonMappingException 
	 */
	public static <T> List<T> listFromString(String jsonArrayStr,
			Class<T> targetClass) throws JsonParseException, JsonMappingException {
		// Empty check
		if (StringUtils.isNotBlank(jsonArrayStr)) {
			try {
				   
				JavaType javaType = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, targetClass); 
				return MAPPER.readValue(jsonArrayStr, javaType);
			} catch ( JsonParseException jpe) {
				throw jpe;
			} catch ( JsonMappingException jme) {
				throw jme;
			}  catch (IOException e) {
				LOGGER.error("Error read List from json. ", e);
			}
		}
		// If jsonArrayStr is empty, return null.
		return null;
	}
	/**
	 * 获取jsonObject对象中域的字符串值.
	 *
	 * @param fieldName 字段名称
	 * @return the string field
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("rawtypes")
	public static String jsonBeanField (String fieldName,String jsonObject ) throws JsonParseException, JsonMappingException {
		Map objMap = JSONUtil.objectFromString(jsonObject, Map.class);
		return String.valueOf(objMap.get(fieldName));
	}

	/**
	 * 获取jsonObject转换的对象类型
	 *
	 * @param <T> 对象泛型
	 * @param beanClass 对象类型
	 * @return the validate bean
	 * @throws BaseException the base exception
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> T jsonObjectBean(Class<T> beanClass,String jsonObject) throws BaseException, JsonParseException, JsonMappingException {
		return JSONUtil.objectFromString(jsonObject, beanClass);
	}
	

}
