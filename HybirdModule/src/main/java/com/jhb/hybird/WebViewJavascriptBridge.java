package com.jhb.hybird;


public interface WebViewJavascriptBridge {
	
	public void send(String data);
	public void send(String data, CallBackFunction responseCallback);

}
