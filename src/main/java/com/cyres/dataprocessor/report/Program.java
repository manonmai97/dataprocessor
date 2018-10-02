package com.cyres.dataprocessor.report;

import java.util.HashMap;
import java.util.Map;

public class Program {
	
	private String contentTitle;
	private String channelAffiliate;
	private String offerStartTime;
	private Map<Integer, Segment> segmentMap;
	
	public Program(){
		segmentMap = new HashMap<Integer, Segment>();
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getChannelAffiliate() {
		return channelAffiliate;
	}

	public void setChannelAffiliate(String channelAffiliate) {
		this.channelAffiliate = channelAffiliate;
	}

	public String getOfferStartTime() {
		return offerStartTime;
	}

	public void setOfferStartTime(String offerStartTime) {
		this.offerStartTime = offerStartTime;
	}

	public Map<Integer, Segment> getSegmentMap() {
		return segmentMap;
	}

	public void setSegmentMap(Map<Integer, Segment> segmentMap) {
		this.segmentMap = segmentMap;
	}

	@Override
	public String toString() {
		return "Program [contentTitle=" + contentTitle + ", channelAffiliate=" + channelAffiliate + ", offerStartTime="
				+ offerStartTime + ", segmentMap=" + segmentMap + "]";
	}
}
