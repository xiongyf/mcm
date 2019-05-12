package com.kevin.mcm.mm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.mapper.MemberMapper;
import com.kevin.mcm.mm.service.IConsumeRecordService;
import com.kevin.mcm.mm.service.IMemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
@Service(value = "memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Resource
    MemberMapper memberMapper;

    @Resource
    IConsumeRecordService consumeRecordService;

    public Page<Member> listMembers(Page<Member> page, Map map) {
        List<Member> members = memberMapper.listMembers(page, map);
        page = page.setRecords(members);
        return page;
    }

    @Override
    @Transactional
    public void removeMemberAndRecord(String id) {
        removeById(id);
        QueryWrapper<ConsumeRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", id);
        consumeRecordService.remove(wrapper);
    }

}
