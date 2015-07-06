package ro.stefan.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ro.stefan.configs.security.custom.CustomAuthenticationSuccessHandler;
import ro.stefan.configs.security.custom.UsersDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsersDetailsServiceImpl usersDetailsService;

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("stefan").password("1234").roles("ADMIN");
        auth.userDetailsService(usersDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/res/**");
    }

    //.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //TODO de cautat cum adaug chestiile de mai jos pt mai multe roluri. nu merge acum ramane pe ultimul cu viewer
        http    .authorizeRequests()
                .antMatchers("/master/**").access("hasRole('ROLE_MASTER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .antMatchers("/viewer/**").access("hasRole('ROLE_VIEWER')")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll().loginPage("/").failureUrl("/?error")
                .usernameParameter("username").passwordParameter("password").successHandler(customAuthenticationSuccessHandler)
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
                .and()
                .csrf();

//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .and()
//                .formLogin().loginPage("/").failureUrl("/?error")
//                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
//                .and()
//                .csrf()
//
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
//                .and()
//                .formLogin().loginPage("/").failureUrl("/?error")
//                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/user")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
//                .and()
//                .csrf()
//
//                .and()
//                .authorizeRequests()
//                .antMatchers("/viewer/**").access("hasRole('ROLE_VIEWER')")
//                .and()
//                .formLogin().loginPage("/").failureUrl("/?error")
//                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/viewer")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
//                .and()
//                .csrf();


//        http.authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .and()
//                .formLogin().loginPage("/").failureUrl("/?error")
//                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
//                .and()
//                .csrf();

//        http.authorizeRequests()
//                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
//                .and()
//                .formLogin().loginPage("/").failureUrl("/?error")
//                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/user")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
//                .and()
//                .csrf();

//        http.authorizeRequests()
//                .antMatchers("/viewer/**").access("hasRole('ROLE_VIEWER')")
//                .and()
//                .formLogin().loginPage("/").failureUrl("/?error")
//                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/viewer")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/?logout")
//                .and()
//                .csrf();
        //  http.formLogin().loginPage("/admin/login").failureUrl("/admin/login?error").defaultSuccessUrl("/main",true).usernameParameter("username").passwordParameter("password");

    }

}
