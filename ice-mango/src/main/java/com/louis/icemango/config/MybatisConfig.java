package com.louis.icemango.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.louis.icemango.**.dao")  //扫描DAO
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //扫描model
        sessionFactory.setTypeAliasesPackage("com.louis.icemango.**.model");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //扫描映射文件
//        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/sqlmap/*.xml"));
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:/mappers/*.xml"));
        return sessionFactory.getObject();
    }
}
