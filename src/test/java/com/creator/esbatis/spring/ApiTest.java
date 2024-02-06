package com.creator.esbatis.spring;

import com.creator.esbatis.spring.dao.IUserDao;
import com.creator.esbatis.spring.entity.Article;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApiTest {

    @Test
    public void test_ClassPathXmlApplicationContext() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("IUserDao", IUserDao.class);
        Article article = userDao.queryUserInfoById(3L);
        System.out.println(article.toString());
    }

}
