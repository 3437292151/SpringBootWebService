package com.yu.confing;

import com.yu.service.AttributeValueService;
import com.yu.service.CcCodingService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;
import java.util.Map;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: webWebService 配置
 */
@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private CcCodingService ccCodingService;

    @Autowired
    private AttributeValueService attributeValueService;


    @Bean
    public ServletRegistrationBean dispatcherServlet1(){
        return new ServletRegistrationBean(new CXFServlet(), "/service/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public Bus springBus()
    {
        return  new SpringBus();
    }

    @Bean
    public Endpoint endpoint(){

        Object[] im = new Object[]{ccCodingService, attributeValueService};

        EndpointImpl endpoint = new EndpointImpl(bus, ccCodingService);
        //endpoint.s
        endpoint.publish("/ccCoding");
        return endpoint;
    }


    /*@Bean
    public Endpoint endpoint1(){

        Object[] im = new Object[]{ccCodingService, attributeValueService};

        EndpointImpl endpoint = new EndpointImpl(bus, attributeValueService);
        //endpoint.s
        endpoint.publish("/attribute");
        return endpoint;
    }*/

}
