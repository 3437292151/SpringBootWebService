package com.yu.client;

import com.yu.service.CcCodingAttributeInfoDTO;
import com.yu.service.CcCodingDTO;
import com.yu.service.CcCodingDescDTO;
import com.yu.service.CcCodingService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: 测试client
 */
public class CcCodingClient {

    public static void main(String args[]) throws Exception{

        jaxWsProxyFactoryBean();
        //testSoapClient();
    }

    /**
     * @Author yuchanglong
     * @Date 2019-5-8
     * @Description 1.自定义client
     **/
    public static void testSoapClient() throws Exception {
        // 接口地址
        String address = "http://localhost:8080/service/ccCoding?wsdl";
        String namespaceURI = "http://service.yu.com";
        String localPart = "CcCodingService";
        SoapClient soapClient = new SoapClient(address, namespaceURI, localPart);
        soapClient.setRequireAuth(true);
        soapClient.setUsername("test");
        soapClient.setPassword("test");
        CcCodingService port = soapClient.creatServiceInstance(CcCodingService.class);
        String result = port.saveCcCoding(getCcCondingDTO());
        System.out.println("返回结果:" + result);
    }

    /**
     * @Author yuchanglong 
     * @Date 2019-3-6
     * @Description 2.代理类工厂的方式,需要拿到对方的接口地址
     * @return void
     **/
    public static void jaxWsProxyFactoryBean(){

        try {
             // 接口地址
             String address = "http://localhost:8080/service/ccCoding?wsdl";
             // 代理工厂
             JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
             // 设置代理地址
             jaxWsProxyFactoryBean.setAddress(address);
            jaxWsProxyFactoryBean.setUsername("admin");
            jaxWsProxyFactoryBean.setPassword("admin");
             // 设置接口类型
             jaxWsProxyFactoryBean.setServiceClass(CcCodingService.class);
             // 创建一个代理接口实现
            CcCodingService ccCodingService = (CcCodingService) jaxWsProxyFactoryBean.create();

             // 调用代理接口的方法调用并返回结果
             String result = ccCodingService.saveCcCoding(getCcCondingDTO());
             System.out.println("返回结果:" + result);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    public static List<CcCodingDTO> getCcCondingDTO(){
        CcCodingDTO ccCodingDTO = new CcCodingDTO();
        ccCodingDTO.setId("123");
        ccCodingDTO.setName("test");
        CcCodingDescDTO ccCodingDescDTO = new CcCodingDescDTO();
        ccCodingDescDTO.setCcId("123");
        ccCodingDescDTO.setLanguage("中文");
        List<CcCodingDescDTO> ccCodingDescDTOList = Arrays.asList(ccCodingDescDTO);
        ccCodingDTO.getCcCodingDescList().addAll(ccCodingDescDTOList);
        //ccCodingDTO.setCcCodingDescList(ccCodingDescDTOList);
        CcCodingAttributeInfoDTO ccCodingAttributeInfoDTO = new CcCodingAttributeInfoDTO();
        ccCodingAttributeInfoDTO.setCcId("123");
        ccCodingAttributeInfoDTO.setAttributeName("test");
        List<CcCodingAttributeInfoDTO> ccCodingAttributeInfoDTOList = Arrays.asList(ccCodingAttributeInfoDTO);
        //ccCodingDTO.setCcCodingAttributeInfoList(ccCodingAttributeInfoDTOList);
        ccCodingDTO.getCcCodingAttributeInfoList().addAll(ccCodingAttributeInfoDTOList);
        return Arrays.asList(ccCodingDTO);
    }
}
