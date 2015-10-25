package org.j45.jobad.content;

import java.util.HashMap;
import java.util.Map;

import org.j45.jobad.content.parsers.PracujPlContentParser;

public class ContentParserFactory {
	
	private static Map<String, ContentParser> contentParsers = new HashMap<>();
	
	public static ContentParser getParser(String contentProviderName) {
		ContentParser parser = null;
		System.out.println("Getting parser for " + contentProviderName);
		if(contentProviderName != null) {
			parser = contentParsers.get(contentProviderName);
			if(parser == null) {
				switch(contentProviderName) {
					case "Pracuj.pl":
						parser = new PracujPlContentParser();
						contentParsers.put(contentProviderName, parser);
						break;
					default:
						System.err.println("Unable to get parser for content " + contentProviderName);
						break;
				}
			}
			return parser;
		}
		return parser;
	}

}
