
package com.yu.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ccCodingDTO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ccCodingDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ccCodingAttributeInfoList" type="{http://service.yu.com}ccCodingAttributeInfoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ccCodingDescList" type="{http://service.yu.com}ccCodingDescDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="disciplineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="largeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="smallName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ccCodingDTO", propOrder = {
    "ccCodingAttributeInfoList",
    "ccCodingDescList",
    "disciplineName",
    "id",
    "largeName",
    "name",
    "smallName"
})
public class CcCodingDTO {

    @XmlElement(nillable = true)
    protected List<CcCodingAttributeInfoDTO> ccCodingAttributeInfoList;
    @XmlElement(nillable = true)
    protected List<CcCodingDescDTO> ccCodingDescList;
    protected String disciplineName;
    protected String id;
    protected String largeName;
    protected String name;
    protected String smallName;

    /**
     * Gets the value of the ccCodingAttributeInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ccCodingAttributeInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCcCodingAttributeInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CcCodingAttributeInfoDTO }
     * 
     * 
     */
    public List<CcCodingAttributeInfoDTO> getCcCodingAttributeInfoList() {
        if (ccCodingAttributeInfoList == null) {
            ccCodingAttributeInfoList = new ArrayList<CcCodingAttributeInfoDTO>();
        }
        return this.ccCodingAttributeInfoList;
    }

    /**
     * Gets the value of the ccCodingDescList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ccCodingDescList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCcCodingDescList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CcCodingDescDTO }
     * 
     * 
     */
    public List<CcCodingDescDTO> getCcCodingDescList() {
        if (ccCodingDescList == null) {
            ccCodingDescList = new ArrayList<CcCodingDescDTO>();
        }
        return this.ccCodingDescList;
    }

    /**
     * 获取disciplineName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisciplineName() {
        return disciplineName;
    }

    /**
     * 设置disciplineName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisciplineName(String value) {
        this.disciplineName = value;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * 获取largeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargeName() {
        return largeName;
    }

    /**
     * 设置largeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargeName(String value) {
        this.largeName = value;
    }

    /**
     * 获取name属性的值。
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
     * 设置name属性的值。
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
     * 获取smallName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmallName() {
        return smallName;
    }

    /**
     * 设置smallName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmallName(String value) {
        this.smallName = value;
    }

}
