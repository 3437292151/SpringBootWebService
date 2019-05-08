package com.yu.service.impl;

import com.yu.service.AttributeValueService;
import com.yu.service.dto.AttributeValueDTO;
import com.yu.service.dto.CcCodingDTO;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-7
 * @Description:
 */
@WebService(serviceName = "AttributeValueService", // 与接口中指定的name一致
        targetNamespace = "http://service.yu.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.yu.service.AttributeValueService"// 接口地址
)
@Component
public class AttributeValueServiceImpl implements AttributeValueService {
    @Override
    public String saveCcCoding(List<CcCodingDTO> CcCodingArray) {
        return null;
    }

    @Override
    public String saveAtributeValue(List<AttributeValueDTO> attributeValueDTOList) {
        return null;
    }
}
