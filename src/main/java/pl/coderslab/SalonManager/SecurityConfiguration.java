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
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.coderslab.SalonManager.service.UserPrincipalDetailsService;

import javax.validation.Validator;

@Configuration
@EnableWebSecurity
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private LoginSuccessHandler loginSuccessHandler;
//
//    @Autowired
//    private SuccessLoginHandler successLoginHandler;

    private final UserPrincipalDetailsService userPrincipalDetailsService;


    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
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
                .loginPage("/authentication/login").permitAll()
//                .successHandler(successLoginHandler)
                .defaultSuccessUrl("/")
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
