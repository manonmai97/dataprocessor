package com.cyres.dataprocessor.data;

public class Segment {
	private String name;
	private double tivoStartOffsetTimestamp;
	private double tivoEndOffsetTimestamp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTivoStartOffsetTimestamp() {
		return tivoStartOffsetTimestamp;
	}
	public void setTivoStartOffsetTimestamp(double tivoStartOffsetTimestamp) {
		this.tivoStartOffsetTimestamp = tivoStartOffsetTimestamp;
	}
	public double getTivoEndOffsetTimestamp() {
		return tivoEndOffsetTimestamp;
	}
	public void setTivoEndOffsetTimestamp(double tivoEndOffsetTimestamp) {
		this.tivoEndOffsetTimestamp = tivoEndOffsetTimestamp;
	}
	@Override
	public String toString() {
		return "Segment [name=" + name + ", tivoStartOffsetTimestamp=" + tivoStartOffsetTimestamp
				+ ", tivoEndOffsetTimestamp=" + tivoEndOffsetTimestamp + "]";
	}
}
