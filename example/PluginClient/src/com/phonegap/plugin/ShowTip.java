package com.phonegap.plugin;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;

import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.phonegap.api.PluginResult.Status;

public class ShowTip extends Plugin {
	/**顯示版號*/
	private final int SHOW_VERSION = 1;
	/**取得目前時間*/
	private final int GET_TIME = 2;
	/**目前版號*/
	private String version = "0.1";
	
	@Override
	/**
	 * 參數說明:[0] = 動作指令 ,[1] = Client所傳送的資料 ,[2] = 回傳ID
	 */
	public PluginResult execute(String action, JSONArray data, String callbackId) {
		//要回傳的插件資源
		PluginResult pluginResult = null;
		
		//插件指令
		String cmd = "ShowTip";
		
		//如果指令跟cmd相同才做動作
		if(action.equals(cmd)){
			
			//回傳字串
			String cbStr;
			
			//依照指令不同回傳字串
			String cmdStr;
			
			try{
				//取得插件子類別指令
				int userCmd = data.getInt(0);
				switch(userCmd){
					case SHOW_VERSION:
						cmdStr = "version: " + version;
						break;
					case GET_TIME:
						cmdStr = "now time: " + new Date().toString();
						break;
					default:
						cmdStr = "command undefined.";
				}
				//取得使用者名稱
				String name = data.getString(1);				
				cbStr = "[ "+ name + "]:" + cmdStr;
				
				//建立插件
				pluginResult = new PluginResult(Status.OK,cbStr);
				
				//回傳插件所組合的字串
				return pluginResult;
				
			//如果資料轉換為JSON發生錯誤則回傳錯誤訊息	
			}catch (JSONException e){
				pluginResult = new PluginResult(Status.JSON_EXCEPTION, "missing argument.");
			}
			
		//沒有該動作指令回傳錯誤訊息
		}else{
			pluginResult = new PluginResult(Status.JSON_EXCEPTION, "missing argument action.");
		}
		//回傳插件所組合的字串
		return pluginResult;
	}

}
