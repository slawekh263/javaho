package org.j45.jobad;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.j45.jobad.advertiser.Advertiser;
import org.j45.jobad.content.ContentFetcher;
import org.j45.jobad.content.ContentParseException;
import org.j45.jobad.content.ContentParser;
import org.j45.jobad.content.ContentParserFactory;
import org.j45.jobad.model.JobAdBean;

@Stateless
@Remote(JobAdAggregatorRemote.class)
public class JobAdAggregatorBean implements JobAdAggregatorRemote /*, ContentRequestor */ {
	
	private static Map<String, List<JobAdBean>> predefinedJobAds = new HashMap<String, List<JobAdBean>>();
	
	private static List<Advertiser> predefinedAdvertisers = new LinkedList<Advertiser>();
	
	static {
		Advertiser a1 = new Advertiser("Pracuj.pl", "http://pracuj.pl/praca");
		predefinedAdvertisers.add(a1);
	}
	
	static {
		
		JobAdBean ja1 = new JobAdBean("Java Developer");
		JobAdBean ja2 = new JobAdBean("Senior Java Developer");
		JobAdBean ja3 = new JobAdBean("Turbo Java Developer");
		List<JobAdBean> l1 = new LinkedList<JobAdBean>();
		List<JobAdBean> l2 = new LinkedList<JobAdBean>();
		l1.add(ja1);
		l1.add(ja2);
		l2.add(ja3);
		
		predefinedJobAds.put("najlepsza_praca.pl", l1);
		predefinedJobAds.put("jestes_zasobem.pl", l2);
	}
	
	@Override
	public Map<String, List<JobAdBean>> getJobAds() {
		Advertiser advertiser;
		String htmlContent;
		ContentParser contentParser = null;
		List<JobAdBean> ads = null;
		List<Advertiser> advertisers = predefinedAdvertisers;
		Map<String, List<JobAdBean>> advAds = new HashMap<>();
		
		Iterator<Advertiser> it = advertisers.iterator();
		try {
		while(it.hasNext()) {
			advertiser = it.next();
			htmlContent = ContentFetcher.fetch(advertiser);
			// System.out.println("HTML: " + htmlContent);
			contentParser = ContentParserFactory.getParser(advertiser.getName());
				ads = contentParser.parse(htmlContent);
			
			// System.out.println("Number of ads for advertiser " + advertiser.getName() + " : " + ads.size());
			advAds.put(advertiser.getName(), ads);
		}
		System.out.println("ads size: " + advAds.size());
		}
		catch (ContentParseException e) {
			e.printStackTrace();
			System.err.println("Unable to parse content : " + e.getLocalizedMessage());
		}
		
		return advAds;
		// return JobAdAggregatorBean.predefinedJobAds;
	}
	/*
	@Override
	public void onContentReceived(String advertiserName, String content) {
		ContentParser parser = null;
		List<JobAdBean> ads = null;
		System.out.println("Content received: " + content);
		if(content != null && content.length() > 0) {
			parser = ContentParserFactory.createContentParser(advertiserName);
			ads = parser.parse(content);
			
			// TODO what how to return it outside ?
		}
		
	}
	*/
}