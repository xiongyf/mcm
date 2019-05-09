package com.kevin.mcm.config.shiro;

import com.kevin.mcm.sys.entity.User;
import com.kevin.mcm.sys.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SysRealm extends AuthorizingRealm {

    @Resource
    IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //authorizationInfo.addRoles(getRolesByUsername(username));//设置角色
        // authorizationInfo.addStringPermissions(getPermissionsByUsername(username));//设置权限
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从主体传过来的认证信息中获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //从数据库获取用户密码
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "SysRealm");
//        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("tomSalt"));//加盐
        return simpleAuthenticationInfo;
    }

    /**
     * 从数据库获取密码
     *
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        User user = userService.getByUserName(username);
        if (user != null) {
            return user.getPassword();
        }
        return null;
    }

    private List<String> getRolesByUsername(String username) {
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("staff");
        return list;
    }

    private List<String> getPermissionsByUsername(String username) {
        List<String> list = new ArrayList<>();
        list.add("user:add");
        list.add("user:update");
        return list;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456");
        System.out.println(md5Hash);
    }
}
