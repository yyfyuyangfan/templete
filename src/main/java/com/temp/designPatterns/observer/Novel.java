package com.temp.designPatterns.observer;

public class Novel extends Subject {

	public void pulish() {
		this.setName("鍝堝埄娉㈢壒");
		System.out.println(" 灏忚鍑虹増浜�");
		this.notifyAllObservers();
	}
}
