package com.creator.esbatis.spring;

import com.creator.mybatis.io.Resources;
import com.creator.mybatis.session.SqlSessionFactory;
import com.creator.mybatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryBean implements FactoryBean<SqlSessionFactory>, InitializingBean {

    private String resource;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public SqlSessionFactory getObject() {
        return sqlSessionFactory;
    }

    @Override
    public Class<?> getObjectType() {
        return SqlSessionFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
