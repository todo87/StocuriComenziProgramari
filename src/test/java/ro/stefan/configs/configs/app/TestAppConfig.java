package ro.stefan.configs.configs.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ro.stefan.configs.configs.persistance.TestPersistenceConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stodoras on 10-Jun-15.
 */

@Configuration
@ComponentScan(basePackages = {"ro.stefan.controller","ro.stefan.serv"})
@Import({TestPersistenceConfig.class})
public class TestAppConfig {



}
