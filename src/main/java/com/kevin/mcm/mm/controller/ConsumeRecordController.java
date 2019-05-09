package com.kevin.mcm.mm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.service.IConsumeRecordService;
import com.kevin.mcm.mm.service.IMemberService;
import com.kevin.mcm.mm.vo.ConsumeRecordVo;
import com.kevin.mcm.sys.BaseResult;
import com.kevin.mcm.sys.util.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Kevin
 * @since 2019-05-07
 */
@RestController
@RequestMapping("/mm/consumeRecord")
public class ConsumeRecordController {

    @Resource
    IConsumeRecordService consumeRecordService;

    /**
     * 条件查询
     *
     * @param
     * @return
     */
    @GetMapping(value = "/list")
    public BaseResult list(ConsumeRecordVo consumeRecordVo, String page, String limit) {
        BaseResult baseResult = new BaseResult();
        Page<ConsumeRecord> consumeRecordPage = new Page<>();
        consumeRecordPage.setCurrent(Integer.valueOf(page == null ? "0" : page));
        consumeRecordPage.setSize(Integer.valueOf(limit == null ? "10" : limit));
        consumeRecordPage = consumeRecordService.listConsumeRecords(consumeRecordPage, consumeRecordVo);
        baseResult.setData(consumeRecordPage.getRecords());
        baseResult.setCount(consumeRecordPage.getTotal());
        return baseResult;
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/one")
    public BaseResult one(String id) {
        BaseResult baseResult = new BaseResult();
        baseResult.setData(consumeRecordService.getById(id));
        return baseResult;
    }

    /**
     * 更新
     *
     * @param
     * @return
     */
    @PostMapping(value = "/saveOrUpdate")
    public BaseResult saveOrUpdate(ConsumeRecord consumeRecord) {
        BaseResult baseResult = new BaseResult();
        try {
            if (StringUtils.isNotEmpty(consumeRecord.getId())) {
                consumeRecordService.updateById(consumeRecord);
            } else {
                consumeRecord.setCreateTime(new Date());
                consumeRecord.setCreateBy(CommonUtil.getUserId());
                consumeRecordService.save(consumeRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCount(500);
        }
        return baseResult;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteById")
    public BaseResult deleteById(String id) {
        BaseResult baseResult = new BaseResult();
        try {
            consumeRecordService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(500);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }

}
