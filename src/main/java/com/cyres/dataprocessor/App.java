package com.cyres.dataprocessor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cyres.dataprocessor.cyres.CyResProcessor;
import com.cyres.dataprocessor.report.Program;
import com.cyres.dataprocessor.report.Report;
import com.cyres.dataprocessor.report.Segment;
import com.cyres.dataprocessor.tivo.TivoProcessor;

public class App {
	
	public enum reportType {
	    CYRES,
	    VENDOR
	}

	public static void main(String[] args) {
		
		//File myFile = new File ("/Users/satya/Documents/workspace/dataprocessor/src/main/files/");
		
		File folderRoot = new File ("C:/Users/Satya/work/cyres/dataprocessor/src/main/files/tivo-v2-satya");
		List<Report> reports = new ArrayList<Report>();
		
		//Dated directory main/files/09-26
		for(File showRoot : folderRoot.listFiles()){
			if(showRoot.isDirectory()){
				
				System.out.println(">file:"+showRoot.getName());
				if("archive".equalsIgnoreCase(showRoot.getName())){
					continue;
				}
				
				//Map<Integer, File> foldersToProcess = new HashMap<Integer, File>(); 
				Map<String, File> foldersToProcess = new HashMap<String, File>();
				
				for(File folder : showRoot.listFiles()){
					if(folder.isDirectory())
					{
						foldersToProcess.put(folder.getName(), folder); 
					}
				}
				
				Iterator<Entry<String,File>> iterator = foldersToProcess.entrySet().iterator(); 
				
				while (iterator.hasNext()) {
					Map.Entry<String,File> entry = (Map.Entry<String,File>) iterator.next();
					File folderToProcess = entry.getValue();
					System.out.println("Key : " + entry.getKey() + " Value :" + folderToProcess);
					
					if(entry.getKey().startsWith("SKIP-")){
						System.out.println("skipping...");
					}else{
						Report report = new Report();
						//Tivo
						TivoProcessor tivo = new TivoProcessor();
						tivo.process(report, folderToProcess);
						
						//CyRes
						CyResProcessor cyres = new CyResProcessor();
						cyres.process(report, folderToProcess);
						
						reports.add(report);
					}
					
				}
				
			}
			
		}

		//Print Report
		printReport(reports);
	}
	
	private static void printReport(List<Report> reports){
		
		System.out.println("\n\nChannel Affiliate  		|	Content Title  						|	Genre	|	offerStartTime	| Ad Segment#	| TiVo Dur | Inner Frame Boundaries  |	 Inner Frame Boundaries DIFF");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			
		for (Report report: reports){
			for (Program program: report.getPrograms()){
				
				for(Segment segment : program.getSegmentMap().values()){
					if(segment.getTiVoAdDuration() == 0)
						continue;
					System.out.print("\n");
					System.out.printf("%-35s", program.getChannelAffiliate()+" |");
					System.out.printf("%-75s", program.getContentTitle()+" |");
					System.out.printf("%-15s", segment.getGenre()+" |");
					System.out.printf("%-18s", program.getOfferStartTime()+" |");
					System.out.printf("%-18s", segment.getSegmentName()+" | ");
					System.out.printf("%-20s", segment.getTiVoAdDuration()+" | ");
					System.out.printf("%-25s", segment.getCyResDurationInnerFrame()+" | ");
					System.out.printf("%12s", segment.getCyResDurationInnerDiff()+" | ");
					System.out.printf("%18s", "");
					//System.out.printf("%-25s", segment.getCyResDurationOuterFrame()+" | ");
					//System.out.printf("%12s", segment.getCyResDurationOuterDiff()+" | ");
				}
				System.out.print("\n");
			}
		}
	}
}
