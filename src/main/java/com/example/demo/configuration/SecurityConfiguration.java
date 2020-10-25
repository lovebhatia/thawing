 package com.example.demo.configuration;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
 import org.springframework.web.servlet.config.annotation.CorsRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 import javax.annotation.Resource;
import javax.sql.DataSource;
 /*
 @Configuration
 @EnableWebSecurity
 @EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
 {
     /*
	 	@Value("${security.signing-key}")
	   private String signingKey;

	   @Value("${security.encoding-strength}")
	   private Integer encodingStrength;

	   @Value("${security.security-realm}")
	   private String securityRealm;

      @Qualifier("userDetailServiceImpl")
	   @Autowired
	   private UserDetailsService userDetailsService;
	   

	
	  @Bean 
	  public BCryptPasswordEncoder encoder()
	  {
		  return new BCryptPasswordEncoder(); 
	  }
	 
	   /*
	   @Bean
	   @Override
	   protected AuthenticationManager authenticationManager() throws Exception {
	      return super.authenticationManager();
	   }

	   @Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(userDetailsService)
	              .passwordEncoder(new BCryptPasswordEncoder());
	   }
	   
	   
	/*
     @Override
     protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .realmName(securityRealm)
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/oauth/token").permitAll();
				//.authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS,"/oauth/token").permitAll()
                //.antMatchers("/api-docs/**").permitAll();
     }




     @Override
     protected void configure(HttpSecurity http) throws Exception {
         //Cross origin resource sharing
         http.cors().and()
                 //starts authorizing configurations.
                 .authorizeRequests()
                 //ignoring the guest's urls...
                 .antMatchers("/resources/**", "/error", "/crack/**").permitAll()
                 //authenticate all remaining URLs.
                 .anyRequest().fullyAuthenticated()
                 .and()
                 .logout().permitAll()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/crack/logout", "POST"))
                 //login form
                 .and()
                 .formLogin().loginPage("/crack/login").and()
                 //enable basic header authentication.
                 .httpBasic().and()
                 //cross-side request forgery.
                 .csrf().disable();
     }

    @Bean
     public WebMvcConfigurer corsConfigurer(){
         return  new WebMvcConfigurer() {
             @Override
             public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**").allowedOrigins("*");
             }
         };
    }

     /*
      @Bean
     public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signingKey);
        return converter;
     }

     @Bean
     public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
     }

     @Bean
     @Primary //Making this primary to avoid any accidental duplication with another token service instance of the same name
     public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
     }


 }
     */