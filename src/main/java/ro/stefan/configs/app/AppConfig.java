package ro.stefan.configs.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ro.stefan.configs.persistance.PersistenceConfig;
import ro.stefan.configs.security.SpringSecurityConfig;

/**
 * Created by stodoras on 10-Jun-15.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"ro.stefan.controller","ro.stefan.serv","ro.stefan.configs.security.custom"})
@Import({PersistenceConfig.class, SpringSecurityConfig.class})
public class AppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("/WEB-RES/");
        registry.addResourceHandler("/favicon*").addResourceLocations("/WEB-RES/img/favicon32.ico");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(-1);
//        return multipartResolver;
//    }

    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager manager) {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/app/");
        resolver.setSuffix(".jsp");
        return resolver;

    }

}
