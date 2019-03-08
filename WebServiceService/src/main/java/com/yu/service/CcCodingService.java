package com.yu.service;

import com.yu.service.dto.AttributeValueDTO;
import com.yu.service.dto.CcCodingDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: cc 编码服务
 */
@WebService(targetNamespace="http://service.yu.com")
public interface CcCodingService {

    @WebMethod
    String saveCcCoding(List<CcCodingDTO> CcCodingArray);

    @WebMethod
    String getAtributeValue(@WebParam(name = "name") String name);
}
