package com.temp.designPatterns.chain;

public class DepManager extends Handler {

	@Override
	public String handleFeeRequest(String user, double fee) {
		String str = null;
		if(fee < 1000) {
			str = "閮ㄩ棬缁忕悊澶勭悊杩欎欢浜�";
		}else {
			return this.successor.handleFeeRequest(user, fee);
		}
		return str;
	}

}
