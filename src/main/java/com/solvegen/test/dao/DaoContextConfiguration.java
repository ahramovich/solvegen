package com.solvegen.test.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Maksim Ahramovich
 */
@Configuration
public class DaoContextConfiguration {
    @Bean
    public DataSource bookDataSource() {
        // TODO connection pool
        // TODO use properties file
        return new EmbeddedDatabaseBuilder()
                .setName("dbsolvegen")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("create-db.sql")
                .build();
    }

    @Bean
    public JdbcTemplate bookJdbcTemplate(@Qualifier("bookDataSource") DataSource bookDataSource) {
        return new JdbcTemplate(bookDataSource);
    }

    @Bean
    public BookDao bookDao() {
        return new BookJdbcDao();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("bookDataSource") DataSource bookDataSource) {
        return new DataSourceTransactionManager(bookDataSource);
    }
}
