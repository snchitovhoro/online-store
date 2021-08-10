package edu.miu.cs545.project.onlinestore.config;


import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

//@Configuration
//@EnableR2dbcRepositories
//public class DatabaseConfig extends AbstractR2dbcConfiguration {
//    @Override
//    public ConnectionFactory connectionFactory() {
//        return null;
//    }
////    @Bean
////    public H2ConnectionFactory connectionFactory() {
////        return new H2ConnectionFactory(
////                H2ConnectionConfiguration.builder()
////                        .url("mem:testdb;DB_CLOSE_DELAY=-1;")
////                        .username("sa")
////                        .build()
////        );
////}
////    @Bean
////    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
////        return new R2dbcTransactionManager(connectionFactory);
////    }
//}