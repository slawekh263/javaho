package org.j45.jobad.content;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.j45.jobad.advertiser.Advertiser;

public class ContentFetcher {
	
	private static CloseableHttpAsyncClient asynchronousHttpClient = HttpAsyncClients.createDefault();
	private static CloseableHttpClient synchronousHttpClient = HttpClients.createDefault();
	
	static {
		asynchronousHttpClient.start();
	}
	
	public static String fetch(final Advertiser advertiser) {
		String line;
		StringBuffer sb = new StringBuffer("");
		HttpGet request = new HttpGet(advertiser.getBaseUrl());
		try {
			CloseableHttpResponse response = synchronousHttpClient.execute(request);
			ContentType ct = ContentType.get(response.getEntity());
			System.out.println("Content-type: " + ct.getMimeType());
			// if (ct.equals(ContentType.TEXT_HTML)) {
				InputStream is = response.getEntity().getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					System.out.println("line got: ");
					sb.append(line);
				}
			// }
		} catch (Exception e) {
			System.err.println("Unable to fetch content: " + e.getMessage());
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	// Asynchronous -> target 
	public static void fetch(final Advertiser advertiser, final ContentRequestor requestor) {
	    final HttpGet request2 = new HttpGet(advertiser.getBaseUrl());
	    asynchronousHttpClient.execute(request2, new FutureCallback<HttpResponse>() {

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
