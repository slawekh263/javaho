package org.j45.jobad.content.parsers;

import java.util.LinkedList;
import java.util.List;

import org.j45.jobad.content.ContentParser;
import org.j45.jobad.model.JobAdBean;

public class PracujPlContentParser implements ContentParser {

	@Override
	public List<JobAdBean> parse(String content) {
		List<JobAdBean> ads = new LinkedList<JobAdBean>();
		return ads;
	}

}
