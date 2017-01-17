package com.hpe.digitalsafe.springcore;

public class Tea implements IHotDrink {

	@Override
	public void prepareHotDrink() {
    System.out.println("Dear Customer, we are preparing tea for you");
	}

}
