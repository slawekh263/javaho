package org.j45.jobad;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.j45.jobad.aggregator.JobAdAggregator;
import org.j45.jobad.model.AdvertisedJobAdsMap;

@Stateless
@Remote(JobAdAggregatorRemote.class)
public class JobAdServiceBean implements JobAdAggregatorRemote /*, ContentRequestor */ {
		
	@Override
	public AdvertisedJobAdsMap getJobAds() {
		return new JobAdAggregator().getJobAds();
	}

}