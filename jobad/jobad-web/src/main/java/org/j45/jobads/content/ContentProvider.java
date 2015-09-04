package org.j45.jobads.content;

import org.j45.jobad.web.Advertiser;
import org.j45.jobads.filter.FilterCriteria;

public interface ContentProvider {
	
	String getContent(Advertiser advertiser, FilterCriteria criteria);
	
}
