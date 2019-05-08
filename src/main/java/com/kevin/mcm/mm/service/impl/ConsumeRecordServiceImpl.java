package com.kevin.mcm.mm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.mapper.ConsumeRecordMapper;
import com.kevin.mcm.mm.mapper.MemberMapper;
import com.kevin.mcm.mm.service.IConsumeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.mcm.mm.vo.ConsumeRecordVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2019-05-07
 */
@Service(value = "consumeRecordService")
public class ConsumeRecordServiceImpl extends ServiceImpl<ConsumeRecordMapper, ConsumeRecord> implements IConsumeRecordService {

    @Resource
    ConsumeRecordMapper consumeRecordMapper;

    @Override
    public Page<ConsumeRecord> listConsumeRecords(Page<ConsumeRecord> page, ConsumeRecordVo consumeRecordVo) {
        List<ConsumeRecord> consumeRecords = consumeRecordMapper.listConsumeRecords(page, consumeRecordVo);
        page = page.setRecords(consumeRecords);
        return page;
    }

}
