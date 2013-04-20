package com.exmple.testehttp.connection;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Handler;
import android.util.Log;

import com.example.testhttp.core.Constants;

public class Connection{

	private static List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
	
	public Connection(){
		pairs = new ArrayList<BasicNameValuePair>();
	}
	
	public static void createParam(String key, String value){
		pairs.add(new BasicNameValuePair(key, value));
	}
	
	public static String sendRequestPost(String URL) throws UnsupportedEncodingException{
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(URL);
		request.setEntity(new UrlEncodedFormEntity(pairs));
		HttpResponse response;
		String responseStr;
		try {
			response = client.execute(request);
			responseStr = HttpHelper.request(response);
			return responseStr;
		} catch (Exception e) {
			Log.i(Constants.TAG, "não foi possivel mandar post");
		
		}
		return null;
	}
	
	public static String sendRequestGet(String URL) throws UnsupportedEncodingException{
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL);
		HttpResponse response;
		String responseStr;
		try {
			response = client.execute(request);
			responseStr = HttpHelper.request(response);
			return responseStr;
		} catch (Exception e) {
			Log.i(Constants.TAG, "não foi possivel mandar get");
			Log.e(Constants.TAG, e.getMessage(), e);
	
		}
		
		return null;
	}
	
	public static List<BasicNameValuePair> getPairs() {
		return pairs;
	}

	public static void setPairs(List<BasicNameValuePair> pairs) {
		Connection.pairs = pairs;
	}
}