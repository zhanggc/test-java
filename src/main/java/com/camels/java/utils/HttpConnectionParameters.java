/**
 * 项目: message-commons
 * 包名: com.zfj.message.commons.utils
 * 文件名: HttpConnectionParameters.java
 * 创建时间: 2014-4-11 下午2:55:23
 * 2014 支付界科技有限公司版权所有,保留所有权利;
 */
package com.camels.java.utils;

import java.util.Map;

/**
 * @Todo: Http 链接参数
 * @Author: zhanggc
 * @Date: 2014-4-11
 */
public class HttpConnectionParameters {
	
	private String url;
	private String requestMethod;
	private int readTimeout;
	private int connectTimeout;
	private boolean input;
	private boolean output;
	private boolean cache;
	private Map<String,String> requestProperty;
	
	public HttpConnectionParameters(String url, String requestMethod,
			int readTimeout,int connectTimeout , boolean input, boolean output, boolean cache,
			Map<String, String> requestProperty) {
		this.url = url;
		this.requestMethod = requestMethod;
		this.readTimeout = readTimeout;
		this.connectTimeout = connectTimeout;
		this.input = input;
		this.output = output;
		this.cache = cache;
		this.requestProperty = requestProperty;
	}
	
	public HttpConnectionParameters(String url, String requestMethod,Map<String, String> requestProperty){
		this(url,requestMethod,22000,3200,true,true,true,requestProperty);
	}
	public HttpConnectionParameters(String url, String requestMethod,int readTimeout,int connectTimeout ,Map<String, String> requestProperty){
		this(url,requestMethod,readTimeout,connectTimeout,true,true,true,requestProperty);
	}

	public HttpConnectionParameters(String url,Map<String, String> requestProperty){
		this(url,"GET",requestProperty);
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRequestMethod() {
		return requestMethod;
	}

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public boolean isInput() {
		return input;
	}
	public void setInput(boolean input) {
		this.input = input;
	}
	public boolean isOutput() {
		return output;
	}
	public void setOutput(boolean output) {
		this.output = output;
	}
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	public Map<String, String> getRequestProperty() {
		return requestProperty;
	}
	public void setRequestProperty(Map<String, String> requestProperty) {
		this.requestProperty = requestProperty;
	}
	
}
