package org.j45.jobad.content;

public interface ContentRequestor {
	
	public void onContentReceived(String advertiser, String content);
	
	public void onContentParsed();

}
