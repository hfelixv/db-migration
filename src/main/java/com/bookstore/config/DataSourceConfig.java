//package com.bookstore.config;
//
////import com.oracle.oal.g2m.metricsproviderservice.persistence.strategy.TablePrefixPhysicalNamingStrategy;
//import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
//import org.springframework.data.relational.core.dialect.AnsiDialect;
//import org.springframework.data.relational.core.dialect.Dialect;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
//
//@Configuration
//public class DataSourceConfig extends AbstractJdbcConfiguration {
//
//    @Override
//    public Dialect jdbcDialect(NamedParameterJdbcOperations operations) {
//        return AnsiDialect.INSTANCE;
//    }
//
//
////    @Bean
////    public PhysicalNamingStrategy physical() {
////        return new TablePrefixPhysicalNamingStrategy();
////    }
//}