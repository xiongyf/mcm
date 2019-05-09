package com.kevin.mcm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.kevin.mcm.mm.service.IConsumeRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class McmApplicationTests {

    @Resource
    IConsumeRecordService consumeRecordService;

    @Test
    public void contextLoads() {
        QueryWrapper<ConsumeRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", "26");
        consumeRecordService.remove(wrapper);
    }

}
