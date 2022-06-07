package info.fingo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").hasRole("USER")
                .and()
                .httpBasic();
    }

    @Bean
    UserDetailsManager users(DataSource dataSource) {
//        UserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        UserDetailsManager users = new InMemoryUserDetailsManager();
        if (!users.userExists("user")) {
            UserDetails user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("password"))
//                    .roles("USER")
                    .authorities("product:read", "ROLE_USER")
                    .build();
            users.createUser(user);
        }
        if (!users.userExists("admin")) {
            UserDetails admin = User
                    .builder()
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .authorities("product:read", "product:write", "ROLE_USER", "ROLE_ADMIN")
                    .build();
            users.createUser(admin);
        }
        return users;
    }
}
