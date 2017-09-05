package com.temp.designPatterns.strategy;

public class NormalCustomerStrategy implements Strategy {

	@Override
	public double calcPrice(double price) {
		System.out.println("鏂扮敤鎴锋病鏈夋姌鎵�");
		return price;
	}

}
