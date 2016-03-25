package org.j45.jobad.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.j45.jobad.aggregator.JobAdAggregator;
import org.j45.jobad.model.AdvertisedJobAdsMap;
import org.j45.jobad.model.JobAdBean;
import org.j45.jobad.model.JobAds;

@Path("/jobadservice")
@Produces("application/json")
public class JobAdService {

	public JobAdService() {
	}
	
	@GET
	@Path("/alljobads")
	public AdvertisedJobAdsMap getAllJobAds() {
		return new JobAdAggregator().getJobAds();
	}	

	@GET
	public JobAds getJobAds(@PathParam("advertiserId") String advertiserId) {
		return null; // TODO
	}
	
    @GET
    @Path("/jobads/{id}")
    @Produces("application/json")
    public JobAdBean getJobAd(@PathParam("id") String id) {
    	JobAdBean jab =  new JobAdBean("");
    	jab.setId("Only_jobad");
    	jab.setContentsHtml("<html>Dam prace staczowi</html>");
    	return jab;
    }

}
