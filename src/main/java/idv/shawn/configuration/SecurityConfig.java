package idv.shawn.configuration;

import java.nio.file.spi.FileSystemProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

import idv.shawn.service.MyUsersDetailService;



@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("myUsersDetailService")
//	private UserDetailsService  userDetailsService;
	private MyUsersDetailService userDetailsService;
	
	@Autowired
	private WebLogoutHandler webLogoutHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("55555555555");
		auth.userDetailsService(userDetailsService).passwordEncoder(password());
	}

	@Bean
	PasswordEncoder password() {
//		return new BCryptPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		System.out.println("http = " + http);
		 http.authorizeRequests()
		 .antMatchers("/hello").authenticated()
		 .anyRequest().permitAll()
		 .and()
		 .formLogin()
		 .and()
		 .logout()
		 .addLogoutHandler(webLogoutHandler)
		 .and().csrf().disable();
	}

}
