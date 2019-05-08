package com.kevin.mcm.mm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.mcm.mm.entity.Member;
import com.kevin.mcm.mm.vo.ConsumeRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2019-05-07
 */
public interface ConsumeRecordMapper extends BaseMapper<ConsumeRecord> {

    List<ConsumeRecord> listConsumeRecords(@Param("page") Page<ConsumeRecord> page,
                                           @Param("consumeRecordVo") ConsumeRecordVo consumeRecordVo);
}
