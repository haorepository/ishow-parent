package com.java.wisdom.group.ishow.iuserprovider.test;

import com.java.wisdom.group.ishow.iuserprovider.config.TestConfig;
import com.java.wisdom.group.ishow.iuserprovider.mapper.TestInfoMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：terry
 * @date ：Created in 2020/1/19 12:28
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
public class TestTestInfoMapper extends TestConfig {
    @Autowired
    private TestInfoMapper mapper;

    @Test
    public void select(){
        mapper.selectById(1);
    }
}
