package com.kevin.mcm.sys.util;

import org.apache.shiro.SecurityUtils;

public class CommonUtil {

    /**
     * 获取当前用户id
     * @return
     */
    public static String getUserId() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute("userId");
    }
}
