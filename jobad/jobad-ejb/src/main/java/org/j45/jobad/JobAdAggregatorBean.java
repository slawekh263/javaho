package org.j45.jobad;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.j45.jobad.model.JobAdBean;

@Stateless
@Remote(JobAdAggregatorRemote.class)
public class JobAdAggregatorBean implements JobAdAggregatorRemote {
	
	private static Map<String, List<JobAdBean>> jobads = new HashMap<String, List<JobAdBean>>();
	
	static {
		JobAdBean ja1 = new JobAdBean("Java Developer", "Zatrudnie developera Java");
		JobAdBean ja2 = new JobAdBean("Senior Java Developer", "Zatrudnie senior developera Java");
		JobAdBean ja3 = new JobAdBean("Turbo Java Developer", "Zatrudnie turbo developera Java");
		List<JobAdBean> l1 = new LinkedList<JobAdBean>();
		List<JobAdBean> l2 = new LinkedList<JobAdBean>();
		l1.add(ja1);
		l1.add(ja2);
		l2.add(ja3);
		
		jobads.put("najlepsza_praca.pl", l1);
		jobads.put("jestes_zasobem.pl", l2);
	}
	
	@Override
	public Map<String, List<JobAdBean>> getJobAds() {
		return JobAdAggregatorBean.jobads;
	}
}