package com.temp.designPatterns.command;

public class GigaMainboard implements MainboardApi {

	@Override
	public void open() {
		System.out.println("鎶�槈涓绘澘姝ｅ湪鍚姩銆傘�銆�");
	}

	@Override
	public void reset() {
		System.out.println("鎶�槈涓绘澘姝ｅ湪閲嶅惎銆傘�銆�");
	}

}
