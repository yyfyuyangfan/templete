package com.temp.util;

import java.io.IOException;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.DefaultResourceLoader;

@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	/**
	 * 鍙栧緱瀛樺偍鍦ㄩ潤鎬佸彉閲忎腑鐨凙pplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}
	
	public static String getRootRealPath(){
		String rootRealPath ="";
		try {
			rootRealPath=getApplicationContext().getResource("").getFile().getAbsolutePath();
		} catch (IOException e) {
			logger.warn("鑾峰彇绯荤粺鏍圭洰褰曞け璐�");
		}
		return rootRealPath;
	}
	
	public static String getResourceRootRealPath(){
		String rootRealPath ="";
		try {
			rootRealPath=new DefaultResourceLoader().getResource("").getFile().getAbsolutePath();
		} catch (IOException e) {
			logger.warn("鑾峰彇璧勬簮鏍圭洰褰曞け璐�");
		}
		return rootRealPath;
	}
	

	/**
	 * 浠庨潤鎬佸彉閲廰pplicationContext涓彇寰桞ean, 鑷姩杞瀷涓烘墍璧嬪�瀵硅薄鐨勭被鍨�
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 浠庨潤鎬佸彉閲廰pplicationContext涓彇寰桞ean, 鑷姩杞瀷涓烘墍璧嬪�瀵硅薄鐨勭被鍨�
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 娓呴櫎SpringContextHolder涓殑ApplicationContext涓篘ull.
	 */
	public static void clearHolder() {
		if (logger.isDebugEnabled()){
			logger.debug("娓呴櫎SpringContextHolder涓殑ApplicationContext:" + applicationContext);
		}
		applicationContext = null;
	}

	/**
	 * 瀹炵幇ApplicationContextAware鎺ュ彛, 娉ㄥ叆Context鍒伴潤鎬佸彉閲忎腑.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
//		logger.debug("娉ㄥ叆ApplicationContext鍒癝pringContextHolder:{}", applicationContext);

		if (SpringContextHolder.applicationContext != null) {
			logger.info("SpringContextHolder涓殑ApplicationContext琚鐩� 鍘熸湁ApplicationContext涓�" + SpringContextHolder.applicationContext);
		}

		SpringContextHolder.applicationContext = applicationContext; // NOSONAR
	}

	/**
	 * 瀹炵幇DisposableBean鎺ュ彛, 鍦–ontext鍏抽棴鏃舵竻鐞嗛潤鎬佸彉閲�
	 */
	@Override
	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}

	/**
	 * 妫�煡ApplicationContext涓嶄负绌�
	 */
	private static void assertContextInjected() {
		Validate.validState(applicationContext != null, "applicaitonContext灞炴�鏈敞鍏� 璇峰湪applicationContext.xml涓畾涔塖pringContextHolder.");
	}
}
