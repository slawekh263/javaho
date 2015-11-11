package org.j45.jobad.content;

import java.util.List;

import org.j45.jobad.model.JobAdBean;

public interface ContentParser {
	
	public List<JobAdBean> parse(String content) throws ContentParseException;

}
