package org.j45.jobad.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "JobAd")
public class JobAdBean implements Serializable {
	
	private static final long serialVersionUID = 193104823L;
	
	public JobAdBean() {
	}
	
	public JobAdBean(String position) {
		this.position = position;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContentsHtml() {
		return contentsHtml;
	}
	public void setContentsHtml(String contentsHtml) {
		this.contentsHtml = contentsHtml;
	}
	public Offerrer getOfferrer() {
		return offerrer;
	}
	public void setOfferrer(Offerrer offerrer) {
		this.offerrer = offerrer;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public String getDirectUrl() {
		return directUrl;
	}
	public void setDirectUrl(String directUrl) {
		this.directUrl = directUrl;
	}

	private String id;
	private String position;
	private String contentsHtml;
	private Offerrer offerrer;
	private Date validTo;
	private String directUrl;


	// TODO implement equals and hashCode
	
}
