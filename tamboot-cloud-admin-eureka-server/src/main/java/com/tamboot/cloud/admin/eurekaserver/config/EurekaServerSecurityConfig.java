package com.tamboot.cloud.admin.eurekaserver.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.StringUtils;

@Configuration
@EnableWebSecurity
public class EurekaServerSecurityConfig extends WebSecurityConfigurerAdapter implements EnvironmentAware {
    private Environment environment;

    @Override
    public void configure(WebSecurity web) throws Exception {
        String name = environment.getProperty("spring.security.user.name");
        String password = environment.getProperty("spring.security.user.password");
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            web.ignoring().antMatchers("/**");
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
