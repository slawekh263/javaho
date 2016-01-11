package org.j45.jobad.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Wrapper for list of ads grouped by advertiser
 *
 */
@XmlRootElement (name="advertised_jobads")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdvertisedJobAdsMap implements Serializable {
	
	private static final long serialVersionUID = 130948430928L;
	
	private Map<String, List<JobAdBean>> ads;

	public Map<String, List<JobAdBean>> getAds() {
		return ads;
	}

	public void setAds(Map<String, List<JobAdBean>> ads) {
		this.ads = ads;
	}

	public AdvertisedJobAdsMap(Map<String, List<JobAdBean>> _ads) {
		this.ads = _ads;
	}
	

}
