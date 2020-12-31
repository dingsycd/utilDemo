package config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置多数据源
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "messageDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.message")
    public DataSource messageDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "cldbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cldb")
    public DataSource cldbDataSource() {
        return DataSourceBuilder.create().build();
    }
//
//    @Bean
//    public DataSource myRoutingDataSource(@Qualifier("writeDataSource") DataSource writeDataSource,
//                                          @Qualifier("readDataSource") DataSource readDataSource) {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put(DBTypeEnum.WRITE, writeDataSource);
//        targetDataSources.put(DBTypeEnum.READ, readDataSource);
//        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
//        myRoutingDataSource.setDefaultTargetDataSource(writeDataSource);
//        myRoutingDataSource.setTargetDataSources(targetDataSources);
//        return myRoutingDataSource;
//    }

}
