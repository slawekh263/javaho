package org.j45.jobad;

import java.util.List;
import java.util.Map;

import org.j45.jobad.model.JobAdBean;

public interface JobAdAggregatorRemote {
	
	public Map<String, List<JobAdBean>> getJobAds();

}
