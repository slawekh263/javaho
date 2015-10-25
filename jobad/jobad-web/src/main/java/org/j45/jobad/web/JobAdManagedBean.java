package org.j45.jobad.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.j45.jobad.JobAdAggregatorRemote;
import org.j45.jobad.model.JobAdBean;

@Named
@ManagedBean
@RequestScoped
public class JobAdManagedBean implements Serializable {
	
	private static final long serialVersionUID = 33425351L;
	
	@EJB
	private JobAdAggregatorRemote jobsAggregator;
	
	private Map<String, List<JobAdBean>> jobAdvertisements;
	
	// private Map<String, List<JobAdBean>> jobads = new HashMap<String, List<JobAdBean>>();
	/*
	{
		JobAdBean ja1 = new JobAdBean("Java Developer");
		JobAdBean ja2 = new JobAdBean("Senior Java Developer");
		JobAdBean ja3 = new JobAdBean("Turbo Java Developer");
		List<JobAdBean> l1 = new LinkedList<JobAdBean>();
		List<JobAdBean> l2 = new LinkedList<JobAdBean>();
		l1.add(ja1);
		l1.add(ja2);
		l2.add(ja3);
		
		jobads.put("pracuj.pl", l1);
		jobads.put("IT w Krakowie", l2);
	}
	*/

	public Map<String, List<JobAdBean>> getJobAdvertisements() {
		System.out.println("Getting job ADVERTISEMENTS");
		return this.jobsAggregator.getJobAds();
	}
	
	public String getHeading() {
		System.out.println("Getting heading");
		return "Job Ad Aggregator";
	}
	
	@PostConstruct
	public void prepareAdvertisements() {
		System.out.println("Preparing list of advertisements");
		this.jobAdvertisements = this.getJobAdvertisements(); 
	}
	
	public Map<String, List<JobAdBean>> getAdvertisements() {
		return this.jobAdvertisements;
	}

}