package com.sparrow.passport.dao;

import com.sparrow.passport.po.User;
import com.sparrow.protocol.dao.DaoSupport;

public interface UserDAO extends DaoSupport<User, Long> {
    Integer getStatus(Long userId);

    User getUserByEmail(String email);

    User getUserByName(String loginName);
}
