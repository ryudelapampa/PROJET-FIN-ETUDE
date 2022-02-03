package fr.diginamic.projet_final;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fr.diginamic.projet_final.providers.AppAuthProvider;
import fr.diginamic.projet_final.services.UserService;

@Configuration
@EnableWebSecurity
public class SpringConfigSecurity extends WebSecurityConfigurerAdapter {
	
	String url = "http://localhost:8084";
	
	@Autowired
	UserService userDetailsService;

	@Bean
	public AuthenticationProvider getProvider() {
		AppAuthProvider provider = new AppAuthProvider();
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * J'autorise tous les accés à mon app web
		 */
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
//		http.csrf().disable().
//		authenticationProvider(getProvider()).
//		formLogin().loginProcessingUrl("/login").and()
//		.logout().logoutUrl("/logout").invalidateHttpSession(true).and()
//		.authorizeRequests()
//		.antMatchers("/login").permitAll()
//		.antMatchers("/logout").permitAll()
//		.antMatchers("/api/**").permitAll()
//		.anyRequest().authenticated().and()
//		.httpBasic();
		
//		http.authorizeHttpRequests()
//			.antMatchers("login.vue","/css/**","/api/**","api")
//			.permitAll().anyRequest().authenticated().and().formLogin().defaultSuccessUrl(url + "/index.vue", true);
		
		
	}

}
