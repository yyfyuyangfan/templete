package com.temp.designPatterns.observer;

public class ConcreteObserver implements Observer {
	
	private String name;
	
	public ConcreteObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(Subject subject) {
		System.out.println(this.name + "鏀跺埌"+subject.getName() + " 灏忚鐨勫嚭鐗堟秷鎭�");
	}

}
