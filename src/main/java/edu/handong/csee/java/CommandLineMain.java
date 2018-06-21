package edu.handong.csee.java;

import java.io.File;
import java.io.IOException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineMain {
	boolean help;
	String url;
	String savePath;

	public static void main(String[] args) throws ParseException, IOException, java.text.ParseException {
		CommandLineMain cml = new CommandLineMain();
		cml.run(args);

	}

	public void run(String[] args) throws ParseException, IOException, java.text.ParseException {
		Options options = new Options();
		options.addOption(Option.builder("u").longOpt("url")
				.desc("Set a url of a website")
				.hasArg()
				.argName("URL to input")
				.required()
				.build());

		options.addOption(Option.builder("d").longOpt("savePath")
				.desc("Set a path of a directory and filename(.format)")
				.hasArg()   
				.argName("Path name to output")
				.required() 
				.build());		

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());
		CommandLineParser parser =new DefaultParser();

		try {
			CommandLine cmd = parser.parse(options, args);

			url=cmd.getOptionValue("u");
			savePath=cmd.getOptionValue("d");
			File d;
			d=new File(savePath);
			if(!d.getParentFile().isDirectory()) {
				System.out.println("Wrong Onput Path, Please check and retry\n");
				throw new WrongPathException("Onput Path Is Wrong\n");
			}
			help=cmd.hasOption("h");
			UrlReader urlReader = new UrlReader();
			HtmlSaver htmlSaver = new HtmlSaver();
			String urlModified="";
			if(url.contains("https")) {
				urlModified=url.replace("https://", "");
			}
			else if(url.contains("http:")) {
				urlModified=url.replace("http://", "");
			}
			htmlSaver.convertToHtml(urlReader.reader(url), savePath, urlModified);
		}catch (Exception e) {
			System.out.println("ErroMessage: "+e.getMessage());
			printHelp(options);
		}		
	}			
	/**
	 * printHelp method helps how to use this program 
	 * @param options
	 */
	private void printHelp(Options options) {

		HelpFormatter formatter = new HelpFormatter();
		String header = "Html save Program";
		String footer ="\nPlease report issues at https://github.com/jongyook2/ChatCount";
		formatter.printHelp("-u URL -d savePath -h help\n", header, options, footer, true);
	}
}
