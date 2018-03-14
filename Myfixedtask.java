package com.Mytaskwork;

import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.LinkStringFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import com.Mytaskwork.*;

public class Myfixedtask {
	public static String[] getDownloadUrl(String Url, String attrName,String attrValue){
		String downloadurlString[] = new String[25];
		try {
			Parser parser = new Parser(Url);
			parser.setEncoding("Gbk");
			NodeList nodeList = (NodeList)parser.extractAllNodesThatMatch(new HasAttributeFilter(attrName, attrValue));
			for (int i = 0; i < nodeList.size(); i++) {
				LinkTag linkTag = (LinkTag) nodeList.elementAt(i);
				downloadurlString[i] = "http://www.dytt8.net"+linkTag.getLink();
			}
			System.out.println(downloadurlString);
		}catch(ParserException exception){
			exception.printStackTrace();
		}
		return downloadurlString;
	}
	public static void main(String[] args) { 
		String movieurl[] = new String[25];
        movieurl = getDownloadUrl("http://www.dytt8.net/html/gndy/dyzz/index.html","class","ulink");
        for (int i = 0; i < movieurl.length; i++) {
			MytaskworkBee mytaskworkBee = new MytaskworkBee();
			mytaskworkBee.getDownloadUrl(movieurl[i],"ftp");
		}
    }
}
