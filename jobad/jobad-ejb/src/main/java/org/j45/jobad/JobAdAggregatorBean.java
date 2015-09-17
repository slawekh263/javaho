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
import org.j45.jobad.content.ContentParser;
import org.j45.jobad.content.ContentParserFactory;
import org.j45.jobad.content.ContentRequestor;
import org.j45.jobad.model.JobAdBean;

@Stateless
@Remote(JobAdAggregatorRemote.class)
public class JobAdAggregatorBean implements JobAdAggregatorRemote, ContentRequestor {
	
	private static Map<String, List<JobAdBean>> predefinedJobAds = new HashMap<String, List<JobAdBean>>();
	
	private static List<Advertiser> predefinedAdvertisers = new LinkedList<Advertiser>();
	
	static {
		Advertiser a1 = new Advertiser("Pracuj.pl", "pracuj.pl");
		predefinedAdvertisers.add(a1);
	}
	
	static {
		JobAdBean ja1 = new JobAdBean("Java Developer", "Zatrudnie developera Java");
		JobAdBean ja2 = new JobAdBean("Senior Java Developer", "Zatrudnie senior developera Java");
		JobAdBean ja3 = new JobAdBean("Turbo Java Developer", "Zatrudnie turbo developera Java");
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
		// fetch advertis
		List<Advertiser> advertisers = predefinedAdvertisers;
		
		Iterator<Advertiser> it = advertisers.iterator();
		while(it.hasNext()) {
			advertiser = it.next();
			new ContentFetcher().fetch(advertiser, this);
		}
		
		return null;
		
		// return JobAdAggregatorBean.predefinedJobAds;
	}
	
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
}