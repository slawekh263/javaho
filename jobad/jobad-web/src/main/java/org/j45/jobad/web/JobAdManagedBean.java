package org.j45.jobad.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.j45.jobad.JobAdAggregatorRemote;
import org.j45.jobad.model.JobAdBean;

@Named
@ManagedBean
@ConversationScoped
public class JobAdManagedBean implements Serializable {
	
	private static final long serialVersionUID = 33425351L;
	
	@EJB
	private JobAdAggregatorRemote jobsAggregator;
	
	private Map<String, List<JobAdBean>> jobads = new HashMap<String, List<JobAdBean>>();
	/*
	{
		JobAdBean ja1 = new JobAdBean("Java Developer", "Zatrudnie developera Java");
		JobAdBean ja2 = new JobAdBean("Senior Java Developer", "Zatrudnie senior developera Java");
		JobAdBean ja3 = new JobAdBean("Turbo Java Developer", "Zatrudnie turbo developera Java");
		List<JobAdBean> l1 = new LinkedList<JobAdBean>();
		List<JobAdBean> l2 = new LinkedList<JobAdBean>();
		l1.add(ja1);
		l1.add(ja2);
		l2.add(ja3);
		
		jobads.put("pracuj.pl", l1);
		jobads.put("IT w Krakowie", l2);
	}
	*/

	public Map<String, List<JobAdBean>> getJobAds() {
		return this.jobsAggregator.getJobAds();
	}
	
	public String getHeading() {
		return "Job Ad Aggregator";
	}
	
	public String [] getRings() {
		String [] arr = new String[3];
		arr[0] = "1";
		arr[1] = "2";
		arr[2] = "3";
		return arr;
		// return new String[]{"adin", "dwa", "tri"};
	}
	
	public List<String> getAdSources() {
		System.out.println("Getting ad sources");
		String adSource = null;
		List<String> adSourcesList = new LinkedList<String>();
		Map<String, List<JobAdBean>> jobads = this.getJobAds();
		Set<String> adSourcesSet = jobads.keySet();
		System.out.println("Size of adrs: " + adSourcesSet.size());
		Iterator<String> it = adSourcesSet.iterator();
		Iterator<JobAdBean> itAd = null;
		while(it.hasNext()) {
			adSource = it.next();
			adSourcesList.add(adSource);
			System.out.println("Ad source: " + adSource);
			itAd = jobads.get(adSource).iterator();
			while(itAd.hasNext()) {
				JobAdBean ad = itAd.next();
				System.out.println("ad: " + ad.getContentsHtml());
			}
		}
		return adSourcesList;		
	}
	
	/*
	public List<String> getAdSources() {
		System.out.println(Thread.currentThread().getStackTrace());
		List<String> adSourcesList = new LinkedList<String>();
		Set<String> adSources = jobads.keySet();
		Iterator<String> it = adSources.iterator();
		while(it.hasNext()) {
			adSourcesList.add(it.next());
		}
		return adSourcesList;
	}
	*/

}