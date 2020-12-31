package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.message"}, sqlSessionFactoryRef = "messageSqlSessionFactory")
public class MyBatisConfigMessage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DataSource messageDataSource;

    @Bean(name = "messageSqlSessionFactory")
    public SqlSessionFactory messageSqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(messageDataSource);
        bean.setTypeAliasesPackage("com.example.demo.domain.dbo");

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/message/**/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            logger.error("error: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate messageSqlSessionTemplate(SqlSessionFactory messageSqlSessionFactory) {
        return new SqlSessionTemplate(messageSqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager messageTransactionManager() {
        return new DataSourceTransactionManager(messageDataSource);
    }

}
