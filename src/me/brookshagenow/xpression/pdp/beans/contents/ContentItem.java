//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.27 at 04:03:19 PM CDT 
//


package me.brookshagenow.xpression.pdp.beans.contents;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}ImageUsage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LANGUAGE" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PUBLISHERTYPE" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="author" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="content_id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="last_modified_time" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="major_version" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="minor_version" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="origin_id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="shared" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imageUsage"
})
@XmlRootElement(name = "ContentItem")
public class ContentItem {

    @XmlElement(name = "ImageUsage")
    protected List<ImageUsage> imageUsage;
    @XmlAttribute(name = "LANGUAGE", required = true)
    protected String language;
    @XmlAttribute(name = "PUBLISHERTYPE", required = true)
    protected BigInteger publishertype;
    @XmlAttribute(required = true)
    protected String author;
    @XmlAttribute(name = "content_id", required = true)
    protected BigInteger contentId;
    @XmlAttribute(required = true)
    protected String format;
    @XmlAttribute(name = "last_modified_time", required = true)
    protected String lastModifiedTime;
    @XmlAttribute(name = "major_version", required = true)
    protected BigInteger majorVersion;
    @XmlAttribute(name = "minor_version", required = true)
    protected BigInteger minorVersion;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute(name = "origin_id", required = true)
    protected BigInteger originId;
    @XmlAttribute(required = true)
    protected BigInteger shared;
    @XmlAttribute(required = true)
    protected BigInteger type;

    /**
     * Gets the value of the imageUsage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageUsage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageUsage }
     * 
     * 
     */
    public List<ImageUsage> getImageUsage() {
        if (imageUsage == null) {
            imageUsage = new ArrayList<ImageUsage>();
        }
        return this.imageUsage;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLANGUAGE() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLANGUAGE(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the publishertype property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPUBLISHERTYPE() {
        return publishertype;
    }

    /**
     * Sets the value of the publishertype property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPUBLISHERTYPE(BigInteger value) {
        this.publishertype = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the contentId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getContentId() {
        return contentId;
    }

    /**
     * Sets the value of the contentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setContentId(BigInteger value) {
        this.contentId = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the lastModifiedTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * Sets the value of the lastModifiedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModifiedTime(String value) {
        this.lastModifiedTime = value;
    }

    /**
     * Gets the value of the majorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMajorVersion() {
        return majorVersion;
    }

    /**
     * Sets the value of the majorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMajorVersion(BigInteger value) {
        this.majorVersion = value;
    }

    /**
     * Gets the value of the minorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinorVersion() {
        return minorVersion;
    }

    /**
     * Sets the value of the minorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinorVersion(BigInteger value) {
        this.minorVersion = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the originId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOriginId() {
        return originId;
    }

    /**
     * Sets the value of the originId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOriginId(BigInteger value) {
        this.originId = value;
    }

    /**
     * Gets the value of the shared property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getShared() {
        return shared;
    }

    /**
     * Sets the value of the shared property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setShared(BigInteger value) {
        this.shared = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setType(BigInteger value) {
        this.type = value;
    }

}
