package com.yu.service.impl;

import com.yu.domain.AuthUser;
import com.yu.service.CcCodingService;
import com.yu.service.dto.CcCodingDTO;
import com.yu.util.WebServiceContextUtil;
import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: cc 编码服务 实现
 */
@InInterceptors(interceptors = "com.yu.interceptor.AuthInterceptor")
@WebService(serviceName = "CcCodingService", // 与接口中指定的name一致
        targetNamespace = "http://service.yu.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.yu.service.CcCodingService"// 接口地址
)
@Component
public class CcCodingServiceImpl implements CcCodingService {

    @Override
    public String saveCcCoding(List<CcCodingDTO> ccCodingArray) {
        AuthUser authUser = (AuthUser) WebServiceContextUtil.getAttribute("userName");
        String remoteAddr = WebServiceContextUtil.getRemoteAddr();
        System.out.println(ccCodingArray);
        System.out.println(authUser);
        System.out.println(remoteAddr);

        return "ok!";
    }

    @Override
    public String getAtributeValue(String name) {
        System.out.println(name);
        return name;
    }
}
