package com.example.one.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author LiuJiangFeng
 * @ClassName: datasource
 * @Date 2019/2/15 11:20
 */
@Configuration
@EnableTransactionManagement   // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = {
        "com.example.one.dao*"}) //@MapperScan注解扫描DAO类，支持多个包，用逗号隔开。
public class datasource {

    /**
     * 主数据源
     * @return
     */
    @Bean(name="oracleDataSource")
    @Qualifier("oracleDataSource")//spring按照名称注入
    @Primary//spring默认按照类型分配，这个注解告诉spring在忧郁的时候选择此实现类
    @ConfigurationProperties(prefix = "spring.datasource.oracle")//加载配置文件内容
    public DataSource druidOracleDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    /**
     * 丛数据源
     * @return
     */
    @Bean(name="DataSourceOracle2")
    @Qualifier("DataSourceOracle2")
    @ConfigurationProperties(prefix = "spring.datasource2.oracle2")
    public DataSource druidMicrosoftDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean(name = "Oracle2JdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("DataSourceOracle2")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
