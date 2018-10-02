package com.cyres.dataprocessor.tivo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.json.JsonParserFactory;

import com.cyres.dataprocessor.report.*;

public class JsonLoader {
	public void loadVendorFeed(String json, Report report) {
		
		Program program = new Program();
		report.getPrograms().add(program);

		Map<Integer, Segment> segmentMap = program.getSegmentMap();
		
		org.springframework.boot.json.JsonParser springParser = JsonParserFactory.getJsonParser();
		Map<String, Object> result = springParser.parseMap(json);
		
		Iterator it = result.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairTopLevel = (Map.Entry) it.next();
			
			if(pairTopLevel.getKey().equals("clipMetadata")){
				
				LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap)((ArrayList)pairTopLevel.getValue()).get(0);
				for(Object keyTop : linkedHashMap.keySet()) {
					if(keyTop.equals("contentTitle")){
						if(program.getContentTitle() == null){
							program.setContentTitle((String)linkedHashMap.get(keyTop));
						}else{
							program.setContentTitle((String)linkedHashMap.get(keyTop)+ " - "+program.getContentTitle() );
						}
					}else if(keyTop.equals("contentSubtitle")){
						if(program.getContentTitle() == null){
							program.setContentTitle((String)linkedHashMap.get(keyTop));
						}else{
							program.setContentTitle(program.getContentTitle() + " - "+(String)linkedHashMap.get(keyTop));
						}
					}else if(keyTop.equals("channelAffiliate")){
						program.setChannelAffiliate((String)linkedHashMap.get(keyTop));
						
					}else if(keyTop.equals("offerStartTime")){
						program.setOfferStartTime((String)linkedHashMap.get(keyTop));
						
					}else if(keyTop.equals("segment")){
						List<LinkedHashMap<String, Object>> segments = (ArrayList<LinkedHashMap<String, Object>>)linkedHashMap.get(keyTop);
						
						int i = 1;
						for(LinkedHashMap<String, Object> segmentValueMap : segments){
							Segment segment = new Segment();
							segment.setSegmentNumber(i);
							
							for(String key : segmentValueMap.keySet()) {
								if(key.equals("description")){
									String ret = (String) segmentValueMap.get(key);
							        segment.setSegmentName(ret);
								} else if(key.equals("startOffset")){
									String ret = (String) segmentValueMap.get(key);
							        segment.setTivoStartOffsetTimestamp(Long.parseLong(ret));
								} else if(key.equals("endOffset")){
									String ret = (String) segmentValueMap.get(key);
							        segment.setTivoEndOffsetTimestamp(Long.parseLong(ret));
								}
						    }
							i++;
							segmentMap.put(segment.getSegmentNumber(), segment);
						}
					}
				}
			} 
		}
		//System.out.println("segmentList = " + segmentList);
	}
}
