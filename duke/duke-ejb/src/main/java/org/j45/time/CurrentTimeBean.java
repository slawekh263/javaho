package org.j45.time;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(CurrentTimeLocal.class)
public class CurrentTimeBean implements CurrentTimeLocal {
	
	@Override
	public String getCurrentTime() {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.ENGLISH);
		String currentTime = df.format(new Date());
		System.out.println("Current time: " + currentTime);
		return currentTime;
	}

}
