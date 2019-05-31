package com.kevin.mcm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kevin.mcm.mm.entity.ConsumeRecord;
import com.kevin.mcm.mm.service.IConsumeRecordService;
import com.kevin.mcm.sys.BaseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class McmApplicationTests {

    @Resource
    IConsumeRecordService consumeRecordService;

    public void contextLoads() {
        QueryWrapper<ConsumeRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", "26");
        consumeRecordService.remove(wrapper);
    }

    @Test
    public void restTest() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BaseResult> res = restTemplate.getForEntity("http://localhost/mm/member/one?id=4", BaseResult.class);
        System.out.println(res);
        restTemplate.delete("http://localhost/mm/member/deleteById?id=4");
    }

}
