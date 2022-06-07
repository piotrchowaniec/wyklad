package info.fingo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/api/products/**").hasAuthority("write")
                .antMatchers("/api/products/**").hasRole("PRODUCTS")
                .antMatchers("/api/**").authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public UserDetailsManager users(PasswordEncoder passwordEncoder) {
        UserDetails build = User.builder()
                .username("user")
                .password(passwordEncoder.encode("pass"))
                .authorities(new ArrayList<>())
                .build();
        UserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(build);
        userDetailsService.createUser(
                User.builder()
                        .username("piotr")
                        .password(passwordEncoder().encode("pass"))
                        .roles("PRODUCTS")
                        .build()
        );
        userDetailsService.createUser(
                User.builder()
                        .username("user2")
                        .password(passwordEncoder().encode("pass"))
                        .authorities("write", "ROLE_PRODUCTS")
                        .build()
        );
        return userDetailsService;
    }
}
