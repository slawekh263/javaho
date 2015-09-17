package org.j45.jobad.content;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.j45.jobad.advertiser.Advertiser;

public class ContentFetcher {
	
	private CloseableHttpAsyncClient httpclient;
	
	public ContentFetcher() {
		httpclient = HttpAsyncClients.createDefault();
		httpclient.start();
	}
	 
	public void fetch(Advertiser advertiser, final ContentRequestor requestor) {
	    final HttpGet request2 = new HttpGet(advertiser.getBaseUrl());
	    httpclient.execute(request2, new FutureCallback<HttpResponse>() {

	        public void completed(final HttpResponse response2) {
	            System.out.println(request2.getRequestLine() + "->" + response2.getStatusLine());
	            if(requestor != null) {
	            	requestor.onContentReceived(advertiser.getName(), response2.toString());
	            }
	        }

	        public void failed(final Exception ex) {
	            System.out.println(request2.getRequestLine() + "->" + ex);
	        }

	        public void cancelled() {
	            System.out.println(request2.getRequestLine() + " cancelled");
	        }

	    });		
		return;
	}

}
