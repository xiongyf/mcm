package com.kevin.mcm.sys.util;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CommonUtil {

    /**
     * 获取当前用户id
     *
     * @return
     */
    public static String getUserId() {
        return (String) SecurityUtils.getSubject().getSession().getAttribute("userId");
    }

    /**
     * md5加密
     *
     * @return
     */
    public static String md5Encrypt(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return new Md5Hash(str).toString();
    }
}
