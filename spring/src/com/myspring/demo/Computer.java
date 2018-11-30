package com.myspring.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class Computer {
	
	@Resource(name="upan")
	private IUsb iUsb;
	
	public void setiUsb(IUsb iUsb) {
		this.iUsb = iUsb;
	}
	public Computer(IUsb iUsb) {
		// TODO Auto-generated constructor stub
		this.iUsb = iUsb;
	}
	public void readData() {
		//调用u盘中的 outputData();
		iUsb.outPutData();
	}
	public Computer() {
		
	}
}
