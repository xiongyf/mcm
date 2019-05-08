package com.kevin.mcm.mm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.service.IMemberService;
import com.kevin.mcm.sys.BaseResult;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/mm/member")
public class MemberController {

    @Resource
    IMemberService memberService;

    /**
     * 条件查询
     *
     * @param
     * @return
     */
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
        memberPage.setCurrent(Integer.valueOf(page == null ? "0" : page));
        memberPage.setSize(Integer.valueOf(limit == null ? "10" : limit));
        memberPage = memberService.listMembers(memberPage, map);
        baseResult.setData(memberPage.getRecords());
        baseResult.setCount(memberPage.getTotal());
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
        baseResult.setData(memberService.getById(id));
        return baseResult;
    }

    /**
     * 更新
     *
     * @param
     * @return
     */
    @PostMapping(value = "/saveOrUpdate")
    public BaseResult saveOrUpdate(Member member) {
        BaseResult baseResult = new BaseResult();
        try {
            if (StringUtils.isNotEmpty(member.getId())) {
                memberService.updateById(member);
            } else {
                member.setCreateTime(new Date());
                memberService.save(member);
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
            memberService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            baseResult.setCode(500);
            baseResult.setMsg("删除失败");
        }
        return baseResult;
    }

}
