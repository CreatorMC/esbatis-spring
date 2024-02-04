package com.creator.esbatis.spring.dao;

import com.creator.esbatis.spring.entity.User;

public interface IUserDao {
    User queryUserInfoById(Long id);
}
