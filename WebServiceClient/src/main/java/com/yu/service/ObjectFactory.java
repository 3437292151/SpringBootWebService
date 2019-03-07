
package com.yu.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yu.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaveCcCoding_QNAME = new QName("http://service.yu.com", "saveCcCoding");
    private final static QName _SaveCcCodingResponse_QNAME = new QName("http://service.yu.com", "saveCcCodingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yu.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveCcCoding }
     * 
     */
    public SaveCcCoding createSaveCcCoding() {
        return new SaveCcCoding();
    }

    /**
     * Create an instance of {@link SaveCcCodingResponse }
     * 
     */
    public SaveCcCodingResponse createSaveCcCodingResponse() {
        return new SaveCcCodingResponse();
    }

    /**
     * Create an instance of {@link CcCodingDTO }
     * 
     */
    public CcCodingDTO createCcCodingDTO() {
        return new CcCodingDTO();
    }

    /**
     * Create an instance of {@link CcCodingAttributeInfoDTO }
     * 
     */
    public CcCodingAttributeInfoDTO createCcCodingAttributeInfoDTO() {
        return new CcCodingAttributeInfoDTO();
    }

    /**
     * Create an instance of {@link CcCodingDescDTO }
     * 
     */
    public CcCodingDescDTO createCcCodingDescDTO() {
        return new CcCodingDescDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCcCoding }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.yu.com", name = "saveCcCoding")
    public JAXBElement<SaveCcCoding> createSaveCcCoding(SaveCcCoding value) {
        return new JAXBElement<SaveCcCoding>(_SaveCcCoding_QNAME, SaveCcCoding.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCcCodingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.yu.com", name = "saveCcCodingResponse")
    public JAXBElement<SaveCcCodingResponse> createSaveCcCodingResponse(SaveCcCodingResponse value) {
        return new JAXBElement<SaveCcCodingResponse>(_SaveCcCodingResponse_QNAME, SaveCcCodingResponse.class, null, value);
    }

}
