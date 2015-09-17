package org.j45.jobad.content;

import org.j45.jobad.content.parsers.PracujPlContentParser;

public class ContentParserFactory {
	
	public static ContentParser createContentParser(String contentProviderName) {
		ContentParser parser = null;
		switch(contentProviderName) {
			case "pracuj.pl":
				parser = new PracujPlContentParser();
				break;
				
		
		
		}
		return parser;
	}

}
