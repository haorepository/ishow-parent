package com.java.wisdom.group.ishow.icache.servcie;

import com.java.wisdom.group.ishow.ientity.entity.TUser;

/**
 * @author     ： terry
 * @date       ： Created in 2020/4/30 9:42
 * @param:
 * @return：
 */
public interface TUserCacheService {
    TUser getUserByCache();

    boolean cacheUser(TUser user);
}
