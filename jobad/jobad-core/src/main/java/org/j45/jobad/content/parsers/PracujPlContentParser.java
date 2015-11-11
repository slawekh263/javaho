package org.j45.jobad.content.parsers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.j45.jobad.content.ContentParseException;
import org.j45.jobad.content.ContentParser;
import org.j45.jobad.model.JobAdBean;
import org.j45.jobad.model.OffererType;
import org.j45.jobad.model.Offerrer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PracujPlContentParser implements ContentParser {

	@Override
	public List<JobAdBean> parse(String content) throws ContentParseException {
		List<JobAdBean> ads = new LinkedList<JobAdBean>();
		JobAdBean ad = null;
		Document doc = Jsoup.parse(content);
		Elements adContainerEls = doc.select("ul.offer__list > li.offer__list_item");
		Elements positionEls = null;
		Elements adContainerChildren;
		Element adContainerEl = null;
		Element child;
		String adPosition = null;
		Elements offerrerEls = null;
		String adOffererName = null;
		Iterator<Element> adIt = adContainerEls.iterator();
		
		System.out.print("Positions: ");
		while(adIt.hasNext()) {
			adContainerEl = adIt.next();
			adContainerChildren = adContainerEl.children(); 
			Iterator<Element> chit = adContainerChildren.iterator();
			
			while(chit.hasNext()) {
				child = chit.next();
				if(child.tag().getName().equals("h2")) {
					positionEls = child.getElementsByClass("offer__list_item_link_name");
					if(positionEls.size() != 1) {
						throw new ContentParseException("Invalid number of ad position name elements: " + positionEls.size());
					}
					adPosition = positionEls.first().html();
				}
				if(child.tag().getName().equals("h3")) {
					offerrerEls = child.getElementsByClass("offer__list_item_link_emp");
					if(offerrerEls.size() != 1) {
						throw new ContentParseException("Invalid number of offerrer name elements: " + offerrerEls.size());
					}			
					adOffererName = offerrerEls.first().html();					
				}
			}
			
			System.out.print(adPosition);
			// offerrerEls = adContainerEl.select("li.offer__list_item > h3.offer__list_item_link > a.offer__list_item_link_emp");

			// System.out.println("Offerrer: " + adOffererName);
			
			ad = new JobAdBean();
			ad.setPosition(adPosition);
			ad.setOfferrer(new Offerrer(OffererType.TARGET, adOffererName));

			ads.add(ad);
		}
		
		return ads;
	}

}
