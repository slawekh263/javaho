package org.j45.jobad;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.j45.jobad.aggregator.JobAdAggregator;
import org.j45.jobad.model.JobAdBean;

@Stateless
@Remote(JobAdAggregatorRemote.class)
public class JobAdServiceBean implements JobAdAggregatorRemote /*, ContentRequestor */ {
		
	@Override
	public Map<String, List<JobAdBean>> getJobAds() {
		return new JobAdAggregator().getJobAds();
	}

}