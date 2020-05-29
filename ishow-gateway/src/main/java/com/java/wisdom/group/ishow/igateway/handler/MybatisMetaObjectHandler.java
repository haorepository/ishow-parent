package com.java.wisdom.group.ishow.igateway.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充数据
 * @author ：terry
 * @date ：Created in 2020/3/31 15:52
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    private static final Logger logger =
            LoggerFactory.getLogger(MybatisMetaObjectHandler.class);
    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("Enter auto fill method when insert");
//        fillStrategy(metaObject,"enableNum", 1);
//        fillStrategy(metaObject,"logicDelete", 0);
//        fillStrategy(metaObject,"creater", "terry_insert");
//        fillStrategy(metaObject,"modifier", "terry_modify");
        fillStrategy(metaObject,"createTime", new Date());
        fillStrategy(metaObject,"modifyTime", new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("Enter auto fill method when update");
//        fillStrategy(metaObject,"modifier", "terry_modify_"+LocalDate.now());
        fillStrategy(metaObject,"modifyTime", new Date());
    }
}
