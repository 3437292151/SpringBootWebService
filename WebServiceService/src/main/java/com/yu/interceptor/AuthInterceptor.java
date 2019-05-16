package com.yu.interceptor;

import com.yu.confing.SpringBeanUtil;
import com.yu.domain.AuthHost;
import com.yu.domain.AuthUser;
import com.yu.repository.AuthHostDao;
import com.yu.repository.AuthUserDao;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPException;
import java.util.Base64;
import java.util.List;

/**
 * @Auther: yuchanglong
 * @Date: 2019-5-7
 * @Description: 权限认证
 */
public class AuthInterceptor extends AbstractSoapInterceptor {

    private static final String BASIC_PREFIX = "Basic ";

    private AuthUserDao authUserDao;

    private AuthHostDao authHostDao;

    public AuthInterceptor() {
        super(Phase.PRE_PROTOCOL);
    }

    public AuthInterceptor(String phase) {
        super(phase);
    }

    public AuthInterceptor(String id, String phase) {
        super(id, phase);
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
        if (authUserDao == null){
            authUserDao = (AuthUserDao) SpringBeanUtil.getBean("authUserDao");
        }
        if (authHostDao == null){
            authHostDao = (AuthHostDao) SpringBeanUtil.getBean("authHostDao");
        }
        HttpServletRequest request = (HttpServletRequest) soapMessage.get(AbstractHTTPDestination.HTTP_REQUEST);
        //认证远程主机是否是授权主机
        AuthHost authHost = new AuthHost();
        authHost.setHost(request.getRemoteHost());
        List<AuthHost> authHosts = authHostDao.selectAuthHost(authHost);
        if (authHosts.size() < 1 ){
            SOAPException exception = new SOAPException("auth failed, Remote host and non-privileged host ");
            throw new Fault(exception);
        }


        //认证是否添加权限
        String auth = request.getHeader("Authorization");
        if (auth == null) {
            SOAPException exception = new SOAPException("auth failed, header [Authorization] not exists");
            throw new Fault(exception);
        }

        //认证模式是否正确
        if (!auth.startsWith(BASIC_PREFIX)) {
            SOAPException exception = new SOAPException("auth failed, header [Authorization] is illegal");
            throw new Fault(exception);
        }
        //认证是否添加用户名与密码
        String plaintext = new String(Base64.getDecoder().decode(auth.substring(BASIC_PREFIX.length())));
        if (StringUtils.isEmpty(plaintext) || !plaintext.contains(":")) {
            SOAPException exception = new SOAPException("auth failed, header [Authorization] is illegal");
            throw new Fault(exception);
        }
        String[] userAndPass = plaintext.split(":");
        if (userAndPass.length < 2){
            SOAPException exception = new SOAPException("auth failed, username is null or password is null");
            throw new Fault(exception);
        }
        //认证用户名与密码是否正确
        AuthUser authUser = new AuthUser();
        authUser.setUserName(userAndPass[0]);
        authUser.setPassword(userAndPass[1]);
        List<AuthUser> authUsers = authUserDao.selectAuthUser(authUser);
        if (authUsers.size() < 1){
            SOAPException exception = new SOAPException("auth failed, username or password error");
            throw new Fault(exception);
        }
        request.setAttribute("userName", authUser);

    }
}
