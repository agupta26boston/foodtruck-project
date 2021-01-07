package com.foodtruck.redfin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This represents the Food Truck POJO returned back by the SODA API Client  
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodTruck {
	private String location;
	private String start24;
	private String end24;
	private String locationdesc;
	private String optionaltext;
	private String applicant;
	private String starttime;
	private String endtime;
	private String dayofweekstr;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStart24() {
		return start24;
	}
	public void setStart24(String start24) {
		this.start24 = start24;
	}
	public String getEnd24() {
		return end24;
	}
	public void setEnd24(String end24) {
		this.end24 = end24;
	}
	public String getLocationdesc() {
		return locationdesc;
	}
	public void setLocationdesc(String locationdesc) {
		this.locationdesc = locationdesc;
	}
	public String getOptionaltext() {
		return optionaltext;
	}
	public void setOptionaltext(String optionaltext) {
		this.optionaltext = optionaltext;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDayofweekstr() {
		return dayofweekstr;
	}
	public void setDayofweekstr(String dayofweekstr) {
		this.dayofweekstr = dayofweekstr;
	}
	@Override
	public String toString() {
		return "FoodTruck [location=" + location + ", start24=" + start24 + ", end24=" + end24 + ", locationdesc="
				+ locationdesc + ", optionaltext=" + optionaltext + ", applicant=" + applicant + ", starttime="
				+ starttime + ", endtime=" + endtime + ", dayofweekstr=" + dayofweekstr + "]";
	}
}
