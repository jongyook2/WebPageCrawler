package edu.handong.csee.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class UrlReader {
	ArrayList <String> urlCollect = new ArrayList <String>();
	public ArrayList<String> reader(String url) throws IOException {
		URL webPage = new URL(url);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(webPage.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			urlCollect.add(inputLine);
			System.out.println(inputLine);
		}
		in.close();
		return urlCollect;
	}
}