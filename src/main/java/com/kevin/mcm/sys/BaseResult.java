package com.kevin.mcm.sys;

import lombok.Data;

@Data
public class BaseResult {
    //错误码
    private Integer code = 200;
    //提示信息
    private String msg = "操作成功！";
    //具体的内容
    private Object data;

    private long total;

}
