package com.stussy.stussyclone20220930h.config;

import com.stussy.stussyclone20220930h.security.AuthFailureHandler;
import com.stussy.stussyclone20220930h.security.PrincipalDetails;
import com.stussy.stussyclone20220930h.service.PrincipalOauth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configurable
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOauth2Service principalOauth2Service;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeHttpRequests()
                .antMatchers("/account/mypage","/index, /checkout")
                .authenticated()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
                .antMatchers("/admin/**","/api/admin/**")
                .permitAll()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .loginPage("/account/login")                 //login page 요청
                .loginProcessingUrl("/account/login")        //login service post 요청
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/index")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(principalOauth2Service)
                .and()
                .defaultSuccessUrl("/index");
    }
}
