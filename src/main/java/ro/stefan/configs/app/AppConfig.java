package ro.stefan.configs.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ro.stefan.configs.persistance.PersistenceConfig;
import ro.stefan.configs.security.SpringSecurityConfig;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).useJaf(false).ignoreAcceptHeader(true).mediaType("html", MediaType.TEXT_HTML).mediaType("json", MediaType.APPLICATION_JSON).defaultContentType(MediaType.TEXT_HTML);
    }

//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(-1);
//        return multipartResolver;
//    }

    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager manager) {

        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        InternalResourceViewResolver r1 = new InternalResourceViewResolver();
        r1.setPrefix("WEB-INF/views/app/");
        r1.setSuffix(".jsp");
        r1.setViewClass(JstlView.class);
        resolvers.add(r1);

        JsonViewResolver r2 = new JsonViewResolver();
        resolvers.add(r2);

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(resolvers);
        resolver.setContentNegotiationManager(manager);
        return resolver;

    }

}
