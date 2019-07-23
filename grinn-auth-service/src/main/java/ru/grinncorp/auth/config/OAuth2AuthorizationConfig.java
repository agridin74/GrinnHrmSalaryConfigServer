package ru.grinncorp.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import ru.grinncorp.auth.service.security.OraUserDetailsService;

public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	
	private TokenStore tokenStore = new InMemoryTokenStore();
	private final String NOOP_PASSWORD_ENCODE = "{noop}";
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private OraUserDetailsService userDetailsService;
	
	@Autowired
	private Environment env;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		 
		//super.configure(clients);
		clients.inMemory()
				.withClient("browser")
				.authorizedGrantTypes("refresh_token","password")
				.scopes("ui")
				.and()
				.withClient("departments-service")
				.secret(env.getProperty("DEPARTMENT_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                ;
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
				.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}
	
	
	

}
