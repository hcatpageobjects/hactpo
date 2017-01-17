package com.hpe.digitalsafe.springcore;

public class Restaurent {

	IHotDrink hotDrink;
	
	public void setHotDrink(IHotDrink hotDrink) {
		this.hotDrink=hotDrink;
	}
	
	public void prepareHotDrink(){
		hotDrink.prepareHotDrink();
	}

}
