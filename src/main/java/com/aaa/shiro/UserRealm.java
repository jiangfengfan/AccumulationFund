package com.aaa.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * className:UserRealm
 * discription:自定义Realm
 * author:zz
 * createTime:2018-12-07 11:16
 */
public class UserRealm extends AuthorizingRealm{
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
       /* SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        info.addStringPermission("example:add");*/
        return null;
    }

    /**
     * 执行认证逻辑
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //假设数据库的用户名和密码
        String name="eric";
        String password="123456";
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
        if(!token.getUsername().equals(name)){
            //用户名不存在
            return null;
        }
        //2.判断密码
        return new SimpleAuthenticationInfo("",password,"");
    }
}
