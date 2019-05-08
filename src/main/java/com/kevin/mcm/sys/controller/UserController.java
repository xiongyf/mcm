package com.kevin.mcm.sys.controller;


import com.kevin.mcm.config.shiro.SysRealm;
import com.kevin.mcm.sys.BaseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Kevin
 * @since 2019-05-08
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @PostMapping("/login")
    public BaseResult login(String username, String password) {
        BaseResult baseResult = new BaseResult();
        SysRealm realm = new SysRealm();

        // 构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            baseResult.setCode(500);
            baseResult.setMsg("用户名或密码错误，登录失败");
            return baseResult;
        }
        baseResult.setMsg("登录成功");
        return baseResult;


    }

    @PostMapping("/logout")
    public BaseResult logout() {
        BaseResult baseResult = new BaseResult();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            baseResult.setCode(500);
            baseResult.setMsg("退出失败");
            return baseResult;
        }
        baseResult.setMsg("退出成功");
        return baseResult;

    }

}
