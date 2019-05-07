package com.kevin.mcm.mm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevin.mcm.mm.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2019-05-07
 */
@Repository
public interface MemberMapper extends BaseMapper<Member> {

    List<Member> listMembers(@Param("page") Page<Member> page, @Param("map") Map map);
}
