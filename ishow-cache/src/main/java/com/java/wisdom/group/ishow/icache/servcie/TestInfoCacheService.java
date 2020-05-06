package com.java.wisdom.group.ishow.icache.servcie;

import com.java.wisdom.group.ishow.ientity.entity.TUser;
import com.java.wisdom.group.ishow.ientity.entity.TestInfo;

/**
 * @author ：terry
 * @date ：Created in 2020/4/30 12:17
 * @description：TODO
 * @version: 1.0
 */
public interface TestInfoCacheService {

    TestInfo getUserByCache();

    boolean cacheUser(TestInfo user);
}
