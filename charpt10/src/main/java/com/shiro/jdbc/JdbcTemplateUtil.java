package com.shiro.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class JdbcTemplateUtil {

    private static JdbcTemplate jdbcTemplate = null;

    public static JdbcTemplate jdbcTemplate(){
        if(jdbcTemplate == null){
            jdbcTemplate = crateJdbcTemplate();
        }
        return jdbcTemplate;
    }

    private static JdbcTemplate crateJdbcTemplate(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/shiro");
        ds.setUsername("root");
        ds.setPassword("root");
        return new JdbcTemplate(ds);
    }


}
