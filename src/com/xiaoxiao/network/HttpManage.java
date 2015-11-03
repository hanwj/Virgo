package com.xiaoxiao.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManage {
	private static HttpManage mHttpManage = null;
	
	private HttpManage()
	{
		
	}
	
	public static HttpManage getInstance()
	{
		if(mHttpManage == null)
		{
			mHttpManage = new HttpManage();
		}
		return mHttpManage;
	}
	
	public void sendGet(String url,String param)
	{
		BufferedReader in = null;
		try {
			URL httpURL = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpURL.openConnection();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void sendPost(String url,String param)
	{
		try {
			URL httpURL = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpURL.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
