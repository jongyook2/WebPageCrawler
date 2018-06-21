package edu.handong.csee.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class HtmlSaver {

	public void convertToHtml(String url, String savePath, String urlSite) throws FileNotFoundException, IOException {
		String format = ".html";
		String fileName=savePath+"/"+urlSite+format;
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));
		out.write(url);
		out.close();
		System.out.println("file is created at "+savePath);
	}
}
