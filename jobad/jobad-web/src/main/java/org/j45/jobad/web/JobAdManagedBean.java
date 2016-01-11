package org.j45.jobad.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
// import javax.inject.Named;

import org.apache.cxf.jaxrs.client.WebClient;
import org.j45.jobad.model.AdvertisedJobAdsMap;
import org.j45.jobad.model.JobAdBean;

// @Named
@ManagedBean(eager=true)
@RequestScoped
public class JobAdManagedBean implements Serializable {
	
	private static final long serialVersionUID = 33425351L;
	
	/*
	@EJB
	private JobAdAggregatorRemote jobsAggregator;
	*/
	
	// private WebClient jobadServiceClient;
	
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
		// TODO use EJB client alternatively

		WebClient client = WebClient.create("http://pc-j45:8080/jobad");
		AdvertisedJobAdsMap ajam = client.path("jobadservice/alljobads").accept("application/json").get(AdvertisedJobAdsMap.class);
		return ajam.getAds();		
		
		// return this.jobsAggregator.getJobAds().getAds();
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