package com.myspring.demo;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String carType;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * @param carType
	 */
	
	public void sayCarType() {
		System.out.println("=="+carType);
	}
	public Car(String carType) {
		super();
		this.carType = carType;
	}

	/**
	 * 
	 */
	public Car() {
		
	}
	

}
