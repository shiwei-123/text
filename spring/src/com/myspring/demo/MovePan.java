package com.myspring.demo;

import org.springframework.stereotype.Component;

@Component
public class MovePan implements IUsb{

	@Override
	public void outPutData() {
		// TODO Auto-generated method stub
		System.out.println("利用移动硬盘输出");
	}
	

}
