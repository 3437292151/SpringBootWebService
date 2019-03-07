package com.yu.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2019-03-07T11:22:59.850+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://service.yu.com", name = "CcCodingService")
@XmlSeeAlso({ObjectFactory.class})
public interface CcCodingService {

    @WebMethod
    @RequestWrapper(localName = "saveCcCoding", targetNamespace = "http://service.yu.com", className = "com.yu.service.SaveCcCoding")
    @ResponseWrapper(localName = "saveCcCodingResponse", targetNamespace = "http://service.yu.com", className = "com.yu.service.SaveCcCodingResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String saveCcCoding(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.yu.service.CcCodingDTO> arg0
    );
}
