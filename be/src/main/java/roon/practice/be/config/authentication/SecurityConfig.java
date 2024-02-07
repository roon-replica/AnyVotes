package roon.practice.be.config.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;
import roon.practice.be.service.OAuth2Service;


// https://medium.com/@iyusubov444/springboot3-oauth2-login-default-config-part-1-c35ca2934818
// https://medium.com/@iyusubov444/springboot3-oauth2-login-save-user-info-part-2-f36f5aa5d458
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final GoogleClientProperties googleClientProperties;
	private final OAuth2Service oAuth2Service;

	public SecurityConfig(GoogleClientProperties googleClientProperties, OAuth2Service oAuth2Service) {
		this.googleClientProperties = googleClientProperties;
		this.oAuth2Service = oAuth2Service;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(authorize -> authorize
						.anyRequest().authenticated()
				).oauth2Login(oauth2 -> oauth2.userInfoEndpoint(endpoint ->  endpoint.userService(oAuth2Service)));
		return http.build();
	}
}
