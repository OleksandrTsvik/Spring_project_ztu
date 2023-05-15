package ztu.education.spring_web_project.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ztu.education.spring_web_project.seed.AdminSeed;
import ztu.education.spring_web_project.seed.DishesSeed;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * Налаштування конфігурації проекту через java код замість xml файлу
 * Все те саме що в applicationContext.xml
 */
@Configuration
@ComponentScan(basePackages = "ztu.education.spring_web_project") // пакет для скана на біни
@PropertySource("classpath:application.properties")
@EnableWebMvc                                                     // заміна mvc:annotation-driven
@EnableTransactionManagement                                      // заміна tx:annotation-driven transaction-manager
@EnableAspectJAutoProxy                                           // заміна aop:aspectj-autoproxy
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login").setViewName("formUserLogin");
        registry.addViewController("/admin/login").setViewName("formAdminLogin");
        registry.addViewController("/access-denied").setViewName("403");
    }

    /**
     * Скорочення для імен jsp файлів
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
            dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            dataSource.setUser(env.getProperty("jdbc.user"));
            dataSource.setPassword(env.getProperty("jdbc.password"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:liquibase/changelog-master.xml");

        return liquibase;
    }

    @DependsOn("liquibase")
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ztu.education.spring_web_project");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("javax.persistence.validation.mode", env.getProperty("hibernate.validation_mode"));

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }

    /**
     * Статичні файли
     */
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public AdminSeed adminSeed() {
        return new AdminSeed();
    }

    @Bean
    public DishesSeed dishesSeed() {
        return new DishesSeed();
    }

    /**
     * Завантаження файлів через форму
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}
