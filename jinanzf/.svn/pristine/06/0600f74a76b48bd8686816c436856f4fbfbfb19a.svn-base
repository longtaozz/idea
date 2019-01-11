package com.zt.jinanzf.common.conf;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.stereotype.Component;

import com.zt.jinanzf.common.util.WebUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends AuthenticatingFilter{
	
	private String header = "x-token";
	
	public JwtAuthenticationFilter(){
		
	}

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader(header);
		return JwtToken.builder().token(token).build();
	}

//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        return false;
//    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return executeLogin(request, response);
    	//throw new AuthenticationException();
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        return true;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest request,
                                     ServletResponse response) {
    	if(ae.getCause() instanceof ExpiredJwtException)
    		WebUtils.SendJson(OpResult.ACCOUNT_LOGIN_TIMEOUT);
    	else if(ae.getCause() instanceof MalformedJwtException)
    		WebUtils.SendJson(OpResult.JWT_FORMAT_ERRORL);
    	else if(ae.getMessage().equals("java.lang.IllegalArgumentException: JWT String argument cannot be null or empty."))
    		WebUtils.SendJson(OpResult.JWT_NO_TOKEN);
    	else
    		WebUtils.SendJson(OpResult.ACCOUNT_LOGIN_FAIL);
    		
        return false;
    }

}
