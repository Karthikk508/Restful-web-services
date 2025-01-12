package com.karthik.rest.webservices.restful_web_services.helloworld;

public class HelloWorldBean {
	
	
	private String msg;

	public HelloWorldBean(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [msg=" + msg + "]";
	}


}
