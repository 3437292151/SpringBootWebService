package com.yu.service.impl;

import com.yu.service.CcCodingService;
import com.yu.service.dto.AttributeValueDTO;
import com.yu.service.dto.CcCodingDTO;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: cc 编码服务 实现
 */
@WebService(serviceName = "CcCodingService", // 与接口中指定的name一致
        targetNamespace = "http://service.yu.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.yu.service.CcCodingService"// 接口地址
)
@Component
public class CcCodingServiceImpl implements CcCodingService {

    @Override
    public String saveCcCoding(List<CcCodingDTO> ccCodingArray) {

        System.out.println(ccCodingArray);

        return "ok!";
    }

    @Override
    public String getAtributeValue(String name) {
        System.out.println(name);
        return name;
    }
}
