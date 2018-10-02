package com.cyres.dataprocessor.tivo;

import java.io.File;
import java.util.Map;

import com.cyres.dataprocessor.AbstractProcessor;
import com.cyres.dataprocessor.App.reportType;
import com.cyres.dataprocessor.report.*;

public class TivoProcessor extends AbstractProcessor{
	
	public void process(Report report, File folder){
		System.out.println(">>>>*********** TivoProcessor begin");
		
		JsonLoader jLoader = new JsonLoader();
		jLoader.loadVendorFeed(super.loadFile(reportType.VENDOR, folder), report);
		
		Map<Integer, Segment> segmentMap  = report.getPrograms().get(0).getSegmentMap();
		int size = segmentMap.size();
		System.out.println(">>>>*********** # of segments: "+ size);
		
		for(int i=0; i<size; i++){
			Segment currentSegment = segmentMap.get(i+1);
			Segment nextSegment;
			
			if(i < (size-1)){
				//System.out.print("Add Segment: "+currentSegment.getSegmentName()+" duration(sec): ");
				nextSegment = segmentMap.get(i+2);
				
				//System.out.print(nextSegment.getTivoStartOffsetTimestamp() +"-"+currentSegment.getTivoEndOffsetTimestamp()+"::");
				
				long diff = nextSegment.getTivoStartOffsetTimestamp()-currentSegment.getTivoEndOffsetTimestamp();
				currentSegment.setTiVoAdDuration(diff);
				//System.out.println(diff);
			}
		}
	}
}