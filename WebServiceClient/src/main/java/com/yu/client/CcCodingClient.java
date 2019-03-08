package com.yu.client;



import com.yu.service.CcCodingAttributeInfoDTO;
import com.yu.service.CcCodingDTO;
import com.yu.service.CcCodingDescDTO;
import com.yu.service.CcCodingService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description:
 */
public class CcCodingClient {
    public static ClassLoader cl = Thread.currentThread().getContextClassLoader();

    public static void main(String args[]) throws Exception{

        jaxWsProxyFactoryBean();
        //jaxWsDynamicClientFactory();
    }

    /**
     * @Author yuchanglong 
     * @Date 2019-3-6
     * @Description 1.代理类工厂的方式,需要拿到对方的接口地址
     * @Param 
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
             // 设置接口类型
             jaxWsProxyFactoryBean.setServiceClass(CcCodingService.class);
             // 创建一个代理接口实现
            CcCodingService ccCodingService = (CcCodingService) jaxWsProxyFactoryBean.create();
            Client proxy= ClientProxy.getClient(ccCodingService);
            HTTPConduit conduit=(HTTPConduit)proxy.getConduit();
            HTTPClientPolicy policy=new HTTPClientPolicy();
            policy.setConnectionTimeout(1000);
            policy.setReceiveTimeout(1000);
            conduit.setClient(policy);

             // 调用代理接口的方法调用并返回结果
             String result = ccCodingService.saveCcCoding(getCcCondingDTO());
             System.out.println("返回结果:" + result);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    /**
     * @Author yuchanglong 
     * @Date 2019-3-6
     * @Description 2：动态调用
     * @Param 
     * @return void
     **/
    public static void jaxWsDynamicClientFactory(){
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:8080/service/ccCoding?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects= new Object[0];
        try {
            objects = client.invoke("saveCcCoding", getCcCondingDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出调用结果
        System.out.println("返回结果: "+objects[0].toString());
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
