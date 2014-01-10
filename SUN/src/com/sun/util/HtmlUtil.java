package com.sun.util;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlUtil {
	private static String html;

	public static String LimitImgWidth(String src, Integer Width) {
		html = src;
		parseString();
		System.out.println(html);
		return html;
	}

	public static void parseString() {
		Document doc = Jsoup.parse(html);
		System.out.println(doc);
		Elements es = doc.select("img");
		System.out.println("--------------->");
		System.out.println(es);
		Iterator<Element> it = es.iterator();

		while (it.hasNext()) {
			Element next = it.next();
			String width = next.attr("width");
			if (width.isEmpty()||Integer.valueOf(width) > 500) {
				next.attr("width", String.valueOf("500"));
			}
		}
		System.out.println("--------------->");
		html = doc.html();
	}
}
