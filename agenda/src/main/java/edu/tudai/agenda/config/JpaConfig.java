package edu.tudai.agenda.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class JpaConfig {
//
//	@Bean
//	public DataSource getDataSource() {
//        @SuppressWarnings("rawtypes")
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/db_arq_web_tpfinal");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("password");
//        return dataSourceBuilder.build();
//    }
//}
