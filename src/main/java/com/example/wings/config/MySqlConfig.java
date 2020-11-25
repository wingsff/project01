package com.example.wings.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author Administrator
 */
@Configuration
@MapperScan(basePackages = "com.example.wings.domain.mapper", sqlSessionFactoryRef = "mySqlSessionFactory")
public class MySqlConfig {


    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;

    @Primary
    @Bean(name = "mySqlDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource mySqlDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory mySqlSessionFactory(@Qualifier("mySqlDatasource") DataSource mySqlDatasource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mySqlDatasource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocation));
        return sessionFactory.getObject();
    }

    @Primary
    @Bean(name = "mySqlTransactionManager")
    public DataSourceTransactionManager mySqlTransactionManager() {
        return new DataSourceTransactionManager(mySqlDatasource());
    }
}
