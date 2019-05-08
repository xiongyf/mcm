package com.kevin.mcm.mm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.vo.ConsumeRecordVo;

import java.util.List;
import java.util.Map;

public interface IConsumeRecordService extends IService<ConsumeRecord> {

    Page<ConsumeRecord> listConsumeRecords(Page<ConsumeRecord> page, ConsumeRecordVo consumeRecordVo);

}
