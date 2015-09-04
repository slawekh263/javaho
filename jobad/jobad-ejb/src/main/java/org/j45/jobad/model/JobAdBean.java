package org.j45.jobad.model;

public class JobAdBean {
	
	public JobAdBean() {
	}
	
	public JobAdBean(String title, String contents) {
		super();
		this.title = title;
		this.contents = contents;
	}
	
	private String title;
	private String contents;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	// TODO implement equals and hashCode
	
}
