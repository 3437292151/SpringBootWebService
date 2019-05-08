package com.yu.client;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Auther: yuchanglong
 * @Date: 2019-5-8
 * @Description: SoapClient
 */
@Data
public class SoapClient {

    private String WSDL;

    private String namespaceURI;

    private String localPart;

    private boolean requireAuth = false;

    private String username;

    private String password;

    public SoapClient() {
    }

    public SoapClient(String WSDL, String namespaceURI, String localPart) {
        this.WSDL = WSDL;
        this.namespaceURI = namespaceURI;
        this.localPart = localPart;
    }

    public SoapClient(String WSDL, String namespaceURI, String localPart, boolean requireAuth, String username, String password) {
        this.WSDL = WSDL;
        this.namespaceURI = namespaceURI;
        this.localPart = localPart;
        this.requireAuth = requireAuth;
        this.username = username;
        this.password = password;
    }

    /**
     * @Author yuchanglong 
     * @Date 2019-5-8
     * @Description 创建service实例
     * @Param service接口
     * @return T
     **/
    public <T> T creatServiceInstance(Class<T> serviceInterface) throws MalformedURLException {
        URL url = new URL(WSDL);
        QName qName = new QName(namespaceURI, localPart);
        Service service = Service.create(url, qName);
        T port = service.getPort(serviceInterface);
        if (requireAuth){
            BindingProvider prov = (BindingProvider) port;
            prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
            prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
        }
        return port;
    }
}
