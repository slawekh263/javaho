package org.j45.jobads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class JobAdAggregatorBean {
	
	private Map<String, List<JobAdBean>> jobads = new HashMap<String, List<JobAdBean>>();
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

	public Map<String, List<JobAdBean>> getJobAds() {
		return this.jobads;
	}
	
	public List<String> getAdSources() {
		List<String> adSourcesList = new LinkedList<String>();
		Set<String> adSources = jobads.keySet();
		Iterator<String> it = adSources.iterator();
		while(it.hasNext()) {
			adSourcesList.add(it.next());
		}
		return adSourcesList;
	}

}