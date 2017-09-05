package com.temp.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DataTravel {

	private static List<String> inputs = new ArrayList<>();
	private static Stack<String> travelStack = new Stack<>();
	
	public static void main(String[] args) {
		JSONArray array = JSON.parseArray(data);
		for(int i = 0; i < array.size(); i++) travel(array.getJSONObject(i));
	}
	
	private static void travel(JSONObject obj) {
		String permission = obj.getString("permission");
		String title = obj.getString("title");
		JSONArray subMenus = obj.getJSONArray("subMenus");
		if(inputs.contains(permission)) {
			System.out.println(title + "鐨勭埗杈堜滑鏄�" + travelStack.toString());
		}
		travelStack.push(title);
		for(int i = 0; i < subMenus.size(); i++) {
			travel(subMenus.getJSONObject(i));
		}
		travelStack.pop();
	}
	
	
	
	static {
		inputs.add("userinformation");
	}
	private static final String data = "[{\"action\":\"#\",\"title\":\"閫氱敤璁剧疆\",\"icon\":\"fa fa-cog\",\"permission\":\"Genger\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"action\":\"usermanager\",\"title\":\"鐢ㄦ埛绠＄悊\",\"icon\":\"fa fa-users\",\"permission\":\"usermanager\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"id\":\"tab1\",\"action\":\"userinformation\",\"title\":\"鐢ㄦ埛淇℃伅\",\"permission\":\"userinformation\",\"isLeaf\":true,\"isTab\":true,\"subMenus\":[]},{\"id\":\"tab2\",\"action\":\"authoritymanager\",\"title\":\"鍔熻兘鏉冮檺\",\"permission\":\"authoritymanager\",\"isLeaf\":true,\"isTab\":true,\"subMenus\":[{\"action\":\"usercenter\",\"title\":\"涓汉涓績2\",\"icon\":\"fa fa-user\",\"permission\":\"usercenter2\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]}]}]},{\"action\":\"usercenter\",\"title\":\"涓汉涓績\",\"icon\":\"fa fa-user\",\"permission\":\"usercenter\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]}]},{\"action\":\"systemsetting\",\"title\":\"绯荤粺璁剧疆\",\"icon\":\"fa fa-cog\",\"permission\":\"systemsetting\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"action\":\"userlogininfo\",\"title\":\"鐢ㄦ埛鐧诲綍淇℃伅\",\"icon\":\"fa fa-navicon\",\"permission\":\"userlogininfo\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]},{\"action\":\"weatherinfo\",\"title\":\"姘旇薄淇℃伅\",\"icon\":\"fa fa-cloud\",\"permission\":\"weatherinfo\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]},{\"action\":\"citysetting\",\"title\":\"鍩庡競璁剧疆\",\"icon\":\"fa fa-cloud\",\"permission\":\"citysetting\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]}]},{\"action\":\"#\",\"title\":\"鐑綉鐩戞帶\",\"icon\":\"fa fa-cog\",\"permission\":\"heatingnetwork\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"action\":\"navigationmap\",\"title\":\"瀵艰埅鍦板浘\",\"icon\":\"fa fa-map\",\"permission\":\"navigationmap\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]},{\"action\":\"monitorcontroll\",\"title\":\"鐑綉鐩戞帶1\",\"icon\":\"fa fa-cog\",\"permission\":\"monitorcontroll\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]},{\"action\":\"reproduction\",\"title\":\"搴曞浘璁剧疆\",\"icon\":\"fa fa-cog\",\"permission\":\"reproduction\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]}]},{\"action\":\"devicemanagement\",\"title\":\"璁惧绠＄悊\",\"icon\":\"fa fa-cog\",\"permission\":\"devicemanagement\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"action\":\"collectorsettings\",\"title\":\"閲囬泦鍣ㄨ缃甛",\"icon\":\"fa fa-navicon\",\"permission\":\"collectorsettings\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]},{\"action\":\"infrastructure\",\"title\":\"鍩虹璁炬柦\",\"icon\":\"fa fa-navicon\",\"permission\":\"infrastructure\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"id\":\"tab1\",\"action\":\"company\",\"title\":\"鍏徃淇℃伅\",\"permission\":\"company\",\"isLeaf\":true,\"isTab\":true,\"subMenus\":[]},{\"id\":\"tab2\",\"action\":\"heatcompany\",\"title\":\"鐑姏鍘俓",\"permission\":\"heatcompany\",\"isLeaf\":true,\"isTab\":true,\"subMenus\":[]},{\"id\":\"tab3\",\"action\":\"heatexchangestation\",\"title\":\"鎹㈢儹绔橽",\"permission\":\"heatexchangestation\",\"isLeaf\":true,\"isTab\":true,\"subMenus\":[]}]}]},{\"action\":\"alarmcenter\",\"title\":\"鎶ヨ涓績\",\"icon\":\"fa fa-cog\",\"permission\":\"alarmcenter\",\"isLeaf\":false,\"isTab\":false,\"subMenus\":[{\"action\":\"equipmentalarminfo\",\"title\":\"璁惧鎶ヨ淇℃伅\",\"icon\":\"fa fa-navicon\",\"permission\":\"equipmentalarminfo\",\"isLeaf\":true,\"isTab\":false,\"subMenus\":[]}]}]";
}