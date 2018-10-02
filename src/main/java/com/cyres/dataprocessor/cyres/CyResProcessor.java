package com.cyres.dataprocessor.cyres;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.cyres.dataprocessor.AbstractProcessor;
import com.cyres.dataprocessor.App.reportType;
import com.cyres.dataprocessor.report.Report;
import com.cyres.dataprocessor.report.Segment;
import com.cyres.dataprocessor.xml.binding.*;
import com.cyres.dataprocessor.xml.binding.CRCVODmDFrameAccurateReport;

public class CyResProcessor extends AbstractProcessor{

	public void process(Report report, File folder) {
		System.out.println(">>>>*********** CyResProcessor begin");
		XmlLoader xLoader = new XmlLoader();
		CRCVODmDFrameAccurateReport cyResReport = xLoader.loadCyResFeed(loadFile(reportType.CYRES, folder));

		List<SegmentDetail> segmentDetails = cyResReport.getSegmentDetail();
		System.out.println(">>>>*********** # of segments: "+ segmentDetails.size());
		String genre = cyResReport.getAssetInformation().getGenre();
		int size = segmentDetails.size();
		Map<Integer, Segment> segmentMap = report.getPrograms().get(0).getSegmentMap();
		
		
		for (int i=0, j=0; i<size; i++, j++) {
			if (i==size-1)
				return;
			
			Segment segment = segmentMap.get(j+1);
			segment.setGenre(genre);
			
			if(segment.getTiVoAdDuration() == 0)
				return;
			
			SegmentDetail currentsegmentDetail = segmentDetails.get(i);
			SegmentDetail nextSegmentDetail = segmentDetails.get(i+1);
			
			if(nextSegmentDetail.getSegmentType().equalsIgnoreCase("PROGRAM")){
				//System.out.println("Found next program");
			}
			else {
				nextSegmentDetail = segmentDetails.get(i+2);
				//System.out.println("Skipped one more to find next program");
				i++;
			}
			/*
			 * Inner Frame Duration
			 * <InPointFrameBoundaryStartSecs>867.10927</InPointFrameBoundaryStartSecs> - S2
   					-	<OutPointFrameBoundaryEndSecs>666.92127</OutPointFrameBoundaryEndSecs> S1
			 */
			Double innerFrameDuration = (nextSegmentDetail.getInPointFrameBoundaryStartSecs() 
					- currentsegmentDetail.getOutPointFrameBoundaryEndSecs())*1000;
			long innerFrameDurationLong = innerFrameDuration.longValue();
			
			segment.setCyResDurationInnerFrame(innerFrameDurationLong);
			segment.setCyResDurationInnerDiff(innerFrameDurationLong - segment.getTiVoAdDuration());
			
			/*
			 * Outer Frame Duration
			 * <InPointFrameBoundaryEndSecs>868.36527</InPointFrameBoundaryEndSecs> - Outerframe duration (program-2) (1003)
		   		-	<OutPointFrameBoundaryStartSecs>665.55727</OutPointFrameBoundaryStartSecs>
			 */
			Double outerFrameDuration = (nextSegmentDetail.getInPointFrameBoundaryEndSecs() 
					- currentsegmentDetail.getOutPointFrameBoundaryStartSecs())*1000;
			long outerFrameDurationLong = outerFrameDuration.longValue();
			segment.setCyResDurationOuterFrame(outerFrameDurationLong);
			segment.setCyResDurationOuterDiff(outerFrameDurationLong - segment.getTiVoAdDuration());
			
//			System.out.println("*****Ad Break: "+(j+1));
//			System.out.println("Inner Frame Duration: "+innerFrameDurationLong);
//			System.out.println("Outer Frame Duration: "+outerFrameDurationLong);
//			System.out.println();
			
		}

	}
}