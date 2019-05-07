package com.kevin.mcm.mm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.service.IMemberService;
import com.kevin.mcm.sys.BaseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/mm/member")
public class MemberController {

    @Resource
    IMemberService memberService;

    @GetMapping(value = "/listMembers")
    public BaseResult listMembers(Member member, String page, String limit) {
        BaseResult baseResult = new BaseResult();
        Map<String, Object> map = new HashMap<>();
        if (member != null) {
            map.put("name", member.getName());
            map.put("phone", member.getPhone());
            map.put("address", member.getAddress());
            map.put("remark", member.getRemark());
        }
        Page<Member> memberPage = new Page<>();
        memberPage.setCurrent(Integer.valueOf(StringUtils.isEmpty(page) ? "0" : page) - 1);
        memberPage.setSize(Integer.valueOf(limit));
        memberPage = memberService.listMembers(memberPage, map);
        baseResult.setData(memberPage.getRecords());
        baseResult.setTotal(memberPage.getTotal());
        return baseResult;
    }

}
