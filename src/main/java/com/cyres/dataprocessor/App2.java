package com.cyres.dataprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.json.JsonParserFactory;

public class App2 {
	
	public enum reportType {
	    CYRES,
	    VENDOR
	}

	public static void main(String[] args) {
		
		//File myFile = new File ("/Users/satya/Documents/workspace/dataprocessor/src/main/files/");
		
		File folderRoot = new File ("C:/Users/Satya/work/cyres/dataprocessor/src/main/files/tivo-v2");
		
		//Dated directory main/files/09-26
		for(File file : folderRoot.listFiles()){
			if(!file.isDirectory() && file.getName().endsWith(".json")){

				System.out.println("\n--"+file.getName()+": ");
				String json = loadFile(file);
				
				org.springframework.boot.json.JsonParser springParser = JsonParserFactory.getJsonParser();
				Map<String, Object> result = springParser.parseMap(json);
				
				Iterator it = result.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairTopLevel = (Map.Entry) it.next();
					
					if(pairTopLevel.getKey().equals("clipMetadata")){
						
						LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap)((ArrayList)pairTopLevel.getValue()).get(0);
						for(Object keyTop : linkedHashMap.keySet()) {
							if(keyTop.equals("contentTitle")){
								System.out.println((String)linkedHashMap.get(keyTop));
								
							}else if(keyTop.equals("contentSubtitle")){
								System.out.println((String)linkedHashMap.get(keyTop));
							}						}
					} 
				}
				//System.out.println("segmentList = " + segmentList);

			}
			
		}

	}

	protected static String loadFile(File file) {
		String fileContents= null;
		
		try {
			
			FileReader fileReader = new FileReader(file);
			BufferedReader buff = new BufferedReader(fileReader);
			
			String sCurrentLine;
			StringBuilder sb = new StringBuilder();
			
			while ((sCurrentLine = buff.readLine()) != null) {
				sb.append(sCurrentLine);
			}
			
			buff.close();
			fileContents = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileContents;
	}

}
