package com.cyres.dataprocessor.cyres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import com.cyres.dataprocessor.xml.binding.CRCVODmDFrameAccurateReport;

public class XmlLoader {
	private JAXBContext jaxbContext;

	public XmlLoader() {
		try {
			jaxbContext = JAXBContext.newInstance("com.cyres.dataprocessor.xml.binding");
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	public CRCVODmDFrameAccurateReport loadCyResFeed(String xml) {
		CRCVODmDFrameAccurateReport report = null;
		
		try {
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xml));
			JAXBElement<?>  element = unmarshaller.unmarshal(reader, CRCVODmDFrameAccurateReport.class);
			report = (CRCVODmDFrameAccurateReport) element.getValue();
			
			//System.out.println("......"+report);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}
		
		return report;
	}
}