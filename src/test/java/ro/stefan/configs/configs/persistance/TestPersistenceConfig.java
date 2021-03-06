package ro.stefan.configs.configs.persistance;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories({"ro.stefan.repo"})
@EnableTransactionManagement
public class TestPersistenceConfig {

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sessionFactory() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setShowSql(true);
        //persistence unit
        lcemfb.setDataSource(dataSource());
        lcemfb.setJpaVendorAdapter(hjva);
        lcemfb.setPackagesToScan("ro.stefan.model");
        lcemfb.setJpaPropertyMap(hibernateProperties());

        return lcemfb;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdepo?autoReconnect=true");
        dataSource.setUsername("demoApp");
        dataSource.setPassword("Skodafabiars180!");

        return dataSource;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory lcemfb) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(lcemfb);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Map<String,String> hibernateProperties() {
        Map<String,String> propMap = new HashMap<>();
        propMap.put("hibernate.hbm2ddl.auto", "create-drop");
        propMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        propMap.put("hibernate.globally_quoted_identifiers", "true");
        propMap.put("hibernate.show_sql", "true");
        return propMap;
    }
}
