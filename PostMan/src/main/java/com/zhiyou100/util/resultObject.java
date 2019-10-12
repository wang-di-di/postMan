package com.zhiyou100.util;

import org.springframework.stereotype.Component;

/*
 * 前后端交互,返回的固定的对象
 * code:   返回的状态码
 * msg:    返回的信息
 * data:   返回的数据
 */
@Component
public class resultObject {
private int code;
private String msg;
private Object data;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public resultObject() {
	super();
}
public resultObject(int code, String msg, Object data) {
	super();
	this.code = code;
	this.msg = msg;
	this.data = data;
}

}
