package edu.handong.csee.java;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class HtmlSaver {

	public void convertToHtml(ArrayList<String>url, String savePath) throws FileNotFoundException, IOException {

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savePath)));
		for(String urlList : url) {
			out.write(urlList);
			out.newLine();
		}
		out.close();
		System.out.println("file is created at "+savePath);
	}
}
