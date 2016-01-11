package org.j45.jobad.aggregator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.j45.jobad.advertiser.Advertiser;
import org.j45.jobad.content.ContentFetcher;
import org.j45.jobad.content.ContentParseException;
import org.j45.jobad.content.ContentParser;
import org.j45.jobad.content.ContentParserFactory;
import org.j45.jobad.model.AdvertisedJobAdsMap;
import org.j45.jobad.model.JobAdBean;

public class JobAdAggregator {

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
	
	public JobAdAggregator() {
	}
	
	public AdvertisedJobAdsMap getJobAds() {
		Advertiser advertiser;
		String htmlContent;
		ContentParser contentParser = null;
		List<JobAdBean> ads = null;
		List<Advertiser> advertisers = predefinedAdvertisers;
		Map<String, List<JobAdBean>> advAds = new HashMap<>();
		AdvertisedJobAdsMap advJobAds = null;
		
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
		
		advJobAds = new AdvertisedJobAdsMap(advAds);
		
		return advJobAds;
		// return JobAdAggregatorBean.predefinedJobAds;		
		
	}

}
