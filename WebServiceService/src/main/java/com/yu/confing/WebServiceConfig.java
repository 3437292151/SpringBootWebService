package com.yu.confing;

import com.yu.service.CcCodingService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

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

    @Bean
    public ServletRegistrationBean dispatcherCXFServlet(){
        return new ServletRegistrationBean(new CXFServlet(), "/service/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public Bus springBus()
    {
        return  new SpringBus();
    }

    @Bean
    public Endpoint endpoint(){

        EndpointImpl endpoint = new EndpointImpl(bus, ccCodingService);
        endpoint.publish("/ccCoding");
        return endpoint;
    }

}
