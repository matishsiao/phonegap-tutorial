//建立ShowTip插件函式
var ShowTipPlugin = function() { };
//建立ShowTip Prototype原型指令
ShowTipPlugin.prototype.showTip = function( data , successCallback, failureCallback ) {    
	//PhoneGap.exec參數說明: 
	//    [0]執行成功呼叫函式 ,[1]執行失敗呼叫函式 , [2]插件類別名稱 , [3]動作指令, [4] HTML傳入的參數
	return PhoneGap.exec(successCallback, failureCallback,  'ShowTip', "ShowTip" , data);
}; 
	
//PhoneGap Plugin 註冊
PhoneGap.addConstructor(
	function() {    
			//加入插件函式,主要是註冊給JavaScript使用的函式
			//參數說明: 
			//        [0] JavaScript要呼叫的函式名稱, [1] JS插件函式
			PhoneGap.addPlugin("showTipPlugin", new ShowTipPlugin());     
	}
);