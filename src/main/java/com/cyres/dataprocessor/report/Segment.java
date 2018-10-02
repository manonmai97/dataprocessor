package com.cyres.dataprocessor.report;

public class Segment {
	private String genre;
	private int segmentNumber;
	private String segmentName;
	private long tivoStartOffsetTimestamp;
	private long tivoEndOffsetTimestamp;
	private long tiVoAdDuration;
	private long cyResDurationInnerFrame;
	private long cyResDurationInnerDiff;
	private long cyResDurationOuterFrame;
	private long cyResDurationOuterDiff;
	public int getSegmentNumber() {
		return segmentNumber;
	}
	public void setSegmentNumber(int segmentNumber) {
		this.segmentNumber = segmentNumber;
	}
	public String getSegmentName() {
		return segmentName;
	}
	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}
	public long getTivoStartOffsetTimestamp() {
		return tivoStartOffsetTimestamp;
	}
	public void setTivoStartOffsetTimestamp(long tivoStartOffsetTimestamp) {
		this.tivoStartOffsetTimestamp = tivoStartOffsetTimestamp;
	}
	public long getTivoEndOffsetTimestamp() {
		return tivoEndOffsetTimestamp;
	}
	public void setTivoEndOffsetTimestamp(long tivoEndOffsetTimestamp) {
		this.tivoEndOffsetTimestamp = tivoEndOffsetTimestamp;
	}
	public long getTiVoAdDuration() {
		return tiVoAdDuration;
	}
	public void setTiVoAdDuration(long tiVoAdDuration) {
		this.tiVoAdDuration = tiVoAdDuration;
	}
	public long getCyResDurationInnerFrame() {
		return cyResDurationInnerFrame;
	}
	public void setCyResDurationInnerFrame(long cyResDurationInnerFrame) {
		this.cyResDurationInnerFrame = cyResDurationInnerFrame;
	}
	public long getCyResDurationInnerDiff() {
		return cyResDurationInnerDiff;
	}
	public void setCyResDurationInnerDiff(long cyResDurationInnerDiff) {
		this.cyResDurationInnerDiff = cyResDurationInnerDiff;
	}
	public long getCyResDurationOuterFrame() {
		return cyResDurationOuterFrame;
	}
	public void setCyResDurationOuterFrame(long cyResDurationOuterFrame) {
		this.cyResDurationOuterFrame = cyResDurationOuterFrame;
	}
	public long getCyResDurationOuterDiff() {
		return cyResDurationOuterDiff;
	}
	public void setCyResDurationOuterDiff(long cyResDurationOuterDiff) {
		this.cyResDurationOuterDiff = cyResDurationOuterDiff;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Segment [genre=" + genre + ", segmentNumber=" + segmentNumber + ", segmentName=" + segmentName
				+ ", tivoStartOffsetTimestamp=" + tivoStartOffsetTimestamp + ", tivoEndOffsetTimestamp="
				+ tivoEndOffsetTimestamp + ", tiVoAdDuration=" + tiVoAdDuration + ", cyResDurationInnerFrame="
				+ cyResDurationInnerFrame + ", cyResDurationInnerDiff=" + cyResDurationInnerDiff
				+ ", cyResDurationOuterFrame=" + cyResDurationOuterFrame + ", cyResDurationOuterDiff="
				+ cyResDurationOuterDiff + "]";
	}
	
}
