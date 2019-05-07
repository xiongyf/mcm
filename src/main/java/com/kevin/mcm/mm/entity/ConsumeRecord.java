package com.kevin.mcm.mm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Kevin
 * @since 2019-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_mm_consume_record")
public class ConsumeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private String id;
    /**
     * 会员id
     */
    private String memberId;

    /**
     * 消费类型，1：购买，2：预存
     */
    private String consumeType;

    /**
     * 消费物品
     */
    private String consumeGoods;

    /**
     * 金额
     */
    private String amount;

    /**
     * 消费时间
     */
    private LocalDateTime consumeTime;

    /**
     * 备注
     */
    private String remark;

    private String createBy;

    private LocalDateTime createTime;


}
