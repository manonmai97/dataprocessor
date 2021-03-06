//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.24 at 12:31:17 PM EDT 
//


package com.cyres.dataprocessor.cyres.xml.binding;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssetInformation" type="{}AssetInformation"/>
 *         &lt;element name="SegmentSummary" type="{}SegmentSummary" maxOccurs="unbounded"/>
 *         &lt;element name="SegmentDetail" type="{}SegmentDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "assetInformation",
    "segmentSummary",
    "segmentDetail"
})
@XmlRootElement(name = "CRC_VODmD_Frame_Accurate_Report")
public class CRCVODmDFrameAccurateReport {

    @XmlElement(name = "AssetInformation", required = true)
    protected AssetInformation assetInformation;
    @XmlElement(name = "SegmentSummary", required = true)
    protected List<SegmentSummary> segmentSummary;
    @XmlElement(name = "SegmentDetail", required = true)
    protected List<SegmentDetail> segmentDetail;

    /**
     * Gets the value of the assetInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AssetInformation }
     *     
     */
    public AssetInformation getAssetInformation() {
        return assetInformation;
    }

    /**
     * Sets the value of the assetInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssetInformation }
     *     
     */
    public void setAssetInformation(AssetInformation value) {
        this.assetInformation = value;
    }

    /**
     * Gets the value of the segmentSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segmentSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegmentSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SegmentSummary }
     * 
     * 
     */
    public List<SegmentSummary> getSegmentSummary() {
        if (segmentSummary == null) {
            segmentSummary = new ArrayList<SegmentSummary>();
        }
        return this.segmentSummary;
    }

    /**
     * Gets the value of the segmentDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segmentDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegmentDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SegmentDetail }
     * 
     * 
     */
    public List<SegmentDetail> getSegmentDetail() {
        if (segmentDetail == null) {
            segmentDetail = new ArrayList<SegmentDetail>();
        }
        return this.segmentDetail;
    }

	public void setSegmentSummary(List<SegmentSummary> segmentSummary) {
		this.segmentSummary = segmentSummary;
	}

	public void setSegmentDetail(List<SegmentDetail> segmentDetail) {
		this.segmentDetail = segmentDetail;
	}

	@Override
	public String toString() {
		return "CRCVODmDFrameAccurateReport [assetInformation=" + assetInformation + ", segmentSummary="
				+ segmentSummary + ", segmentDetail=" + segmentDetail + "]";
	}

}
