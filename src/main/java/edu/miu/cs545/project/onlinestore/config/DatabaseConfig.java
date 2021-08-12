package edu.miu.cs545.project.onlinestore.config;


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