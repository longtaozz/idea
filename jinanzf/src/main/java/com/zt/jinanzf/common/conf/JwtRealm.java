package com.zt.jinanzf.common.conf;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Sets;
import com.zt.jinanzf.common.util.TokenUtil;


public class JwtRealm extends AuthorizingRealm{

    @Autowired
    private TokenUtil tokenUtil;
   // @Autowired
    //private UserService userService;
    
    @Override
    public boolean supports(AuthenticationToken token) {
        //表示此Realm只支持JwtToken类型
        return token instanceof JwtToken;
    }
    
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//String userCode = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
        // 根据username查询角色
		authorizationInfo.addRole("admin");

        // 根据username查询权限
        authorizationInfo.setStringPermissions(Sets.newHashSet("system:*"));

        return authorizationInfo;	
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		JwtToken jwtToken = (JwtToken)authenticationToken;
		String token = jwtToken.getToken();
		try{
			String username = tokenUtil.getUsercodeFromToken(token);
			//TODO 验证Token
			return new SimpleAuthenticationInfo(username,token,getName());
		}catch(Exception e){
			throw new AuthenticationException(e);
		}
	}

}
