package com.yst.config;



import com.yst.pojo.UUser;
import com.yst.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;

/**
 * 自定义 realm
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 从session中获取 user 对象
        Session session = SecurityUtils.getSubject().getSession();
       // UUser user = (UUser) session.getAttribute("USER_SESSION");

        Subject subject = SecurityUtils.getSubject();
        UUser user =(UUser) subject.getPrincipal();

        System.out.println( "执行了================>" );
        // 权限信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println(user.getPower()+":ddddddd:");
        info.addRoles( user.getPower() );
        info.addStringPermissions( user.getPower() );

        Set<String> roles = info.getRoles();

        for (String str  : roles) {
            System.out.println( "角色："+ str );
        }
        Set<String> permissions = info.getStringPermissions();
        for (String str  : permissions) {
            System.out.println( "权限："+ str );
        }


        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        System.out.println( "username="+username+",password="+password );

        // 获取用户名。通过 username 找到该用户
        UUser user = sysUserService.getUserByUserNameWithPermission(username);
        if (StringUtils.isEmpty(user.getUser())){
            log.error("用户不存在");
            return null;
        }

        if( username.equals( user.getUser() ) && password.equals( user.getPassword() ) ){
            // 获取所有session
            Collection<Session> sessions = sessionDAO.getActiveSessions();
            for (Session session: sessions) {
                UUser sysUser = (UUser) session.getAttribute("USER_SESSION");
                // 如果session里面有当前登陆的，则证明是重复登陆的，则将其剔除
                if( sysUser!=null ){
                    if( username.equals( sysUser.getUser() ) ){
                        session.setTimeout(0);
                    }
                }
            }
            // 验证通过了 setSession
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("USER_SESSION", user);

        }

        // 从数据库查询出来的用户名密码，进行验证
        // 用户名，密码，密码盐值，realm 名称
        // 登陆的时候直接调用 subject.login() 即可自动调用该方法
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user , user.getPassword() , getName());


        return info;
    }
}
