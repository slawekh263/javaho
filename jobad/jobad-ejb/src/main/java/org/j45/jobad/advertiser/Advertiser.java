package org.j45.jobad.advertiser;


// @Entity
public class Advertiser {
	
	// @Id
	// @GeneratedValue
	public Advertiser(String name, String baseUrl) {
		this.id = (long) Math.random();
		this.name = name;
		this.baseUrl = baseUrl;
	}
	
	private long id;
	private String name;
	private String baseUrl;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
