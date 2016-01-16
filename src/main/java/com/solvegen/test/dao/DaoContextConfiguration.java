package com.solvegen.test.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Maksim Ahramovich
 */
@Configuration
public class DaoContextConfiguration {
    @Bean
    public DataSource bookDataSource() {
        // TODO connection pool
        // TODO use properties file
        DriverManagerDataSource ds =
                new DriverManagerDataSource("jdbc:mysql://localhost:3306/solvegen", "login", "password");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    @Bean
    public JdbcTemplate bookJdbcTemplate(@Qualifier("bookDataSource") DataSource bookDataSource) {
        return new JdbcTemplate(bookDataSource);
    }

    @Bean
    public BookDao bookDao() {
        return new BookJdbcDao();
    }
}
