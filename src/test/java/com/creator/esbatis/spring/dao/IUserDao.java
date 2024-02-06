package com.creator.esbatis.spring.dao;

import com.creator.esbatis.spring.entity.Article;

public interface IUserDao {
    Article queryUserInfoById(Long id);
}
