package com.cyres.dataprocessor.report;

import java.util.ArrayList;
import java.util.List;

public class Report {
	
	List<Program> programs;
	
	public Report(){
		programs = new ArrayList<Program>();
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public Report buildMockReport(){
//		
//		Program program = new Program();
//		program.setName("Hawaii 5-O");
//		Segment seg = new Segment();
//		seg.setSegmentNumber(1);
//		seg.setTiVoDuration(Double.valueOf("2341234"));
//		seg.setCyResDurationInnerFrame(Double.valueOf("2345265"));
//		seg.setCyResDurationInnerDiff(Double.valueOf("4031"));
//		seg.setCyResDurationOuterFrame(Double.valueOf("2345855"));
//		seg.setCyResDurationOuterDiff(Double.valueOf("4621"));
//		
//		program.getSegments().add(seg);
//		
//		Segment seg2 = new Segment();
//		seg2.setSegmentNumber(1);
//		seg2.setTiVoDuration(Double.valueOf("2341234"));
//		seg2.setCyResDurationInnerFrame(Double.valueOf("2345265"));
//		seg2.setCyResDurationInnerDiff(Double.valueOf("4031"));
//		seg2.setCyResDurationOuterFrame(Double.valueOf("2345855"));
//		seg2.setCyResDurationOuterDiff(Double.valueOf("4621"));
//		
//		program.getSegments().add(seg2);
//		
//		programs.add(program);
//		
//		Program program2 = new Program();
//		program2.setName("Hawaii 5-O");
//		Segment seg3 = new Segment();
//		seg3.setSegmentNumber(1);
//		seg3.setTiVoDuration(Double.valueOf("2341234"));
//		seg3.setCyResDurationInnerFrame(Double.valueOf("2345265"));
//		seg3.setCyResDurationInnerDiff(Double.valueOf("4031"));
//		seg3.setCyResDurationOuterFrame(Double.valueOf("2345855"));
//		seg3.setCyResDurationOuterDiff(Double.valueOf("4621"));
//		
//		program2.getSegments().add(seg3);
//		
//		Segment seg4 = new Segment();
//		seg4.setSegmentNumber(1);
//		seg4.setTiVoDuration(Double.valueOf("2341234"));
//		seg4.setCyResDurationInnerFrame(Double.valueOf("2345265"));
//		seg4.setCyResDurationInnerDiff(Double.valueOf("4031"));
//		seg4.setCyResDurationOuterFrame(Double.valueOf("2345855"));
//		seg4.setCyResDurationOuterDiff(Double.valueOf("4621"));
//		
//		program2.getSegments().add(seg4);
//		
//		programs.add(program2);
		
		Report report = new Report();
		report.setPrograms(programs);
		return report;
	}
	
	@Override
	public String toString() {
		return "Report [programs=" + programs + "]";
	}
}
