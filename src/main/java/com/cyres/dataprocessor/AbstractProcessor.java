package com.cyres.dataprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.cyres.dataprocessor.App.reportType;

public abstract class AbstractProcessor {
	
	protected static String loadFile(reportType type, File folder) {
		String fileContents= null;
		
		try {
			File xmlFile = null, jsonFile=null;
					
			for(File file : folder.listFiles()){
				if( file.getName().endsWith(".json")){
					jsonFile = file;
				}else{
					xmlFile = file;
				}
				
			}
			
			File fileToRead = (type == reportType.CYRES) ? xmlFile:jsonFile;
			
			FileReader file = new FileReader(fileToRead);
			BufferedReader buff = new BufferedReader(file);
			
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