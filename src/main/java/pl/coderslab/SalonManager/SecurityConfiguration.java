package pl.coderslab.SalonManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.coderslab.SalonManager.service.UserPrincipalDetailsService;

@Configuration
@EnableWebSecurity
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final UserPrincipalDetailsService userPrincipalDetailsService;

    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SuccessLoginHandler loginHandler() {
        return new SuccessLoginHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/js/**", "/css/**", "/img/**").permitAll()
                .antMatchers("/userAccount/**").hasRole("USER")
                .antMatchers("/administration/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .and()
                .formLogin()
                .loginProcessingUrl("/authentication/login")
                .loginPage("/authentication/login").permitAll()
                .failureUrl("/authentication/login?error=true")
//                .defaultSuccessUrl("/authentication/login?loginSuccess=true")
                .successHandler(loginHandler())
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll();
    }
}
