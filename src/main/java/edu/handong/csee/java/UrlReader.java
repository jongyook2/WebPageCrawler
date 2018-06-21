package edu.handong.csee.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class UrlReader {
	String result="";
	public String reader(String url) throws IOException {
		URL webPage = new URL(url);
		HttpURLConnection urlCon=(HttpURLConnection)webPage.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(urlCon.getInputStream(),"utf-8"));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			result+=inputLine+"\r\n";
		}
		in.close();
		return result;
	}
}