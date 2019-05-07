package com.kevin.mcm.mm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.mcm.mm.entity.Member;

import java.util.List;
import java.util.Map;

public interface IMemberService extends IService<Member> {

    Page<Member> listMembers(Page<Member> memberPage, Map map);

}
