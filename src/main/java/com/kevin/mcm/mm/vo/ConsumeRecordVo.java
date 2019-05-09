package com.kevin.mcm.mm.vo;

import com.kevin.mcm.mm.entity.ConsumeRecord;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ConsumeRecordVo extends ConsumeRecord {

    /**
     * 金额
     */
    private String beginAmount;
    private String endAmount;

    /**
     * 消费时间
     */
    private String beginConsumeTime;

    private String endConsumeTime;
}
