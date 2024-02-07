package roon.practice.be.config.authentication;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration // https://blog.yevgnenll.me/posts/spring-configuration-properties-fetch-application-properties
@ConfigurationProperties("spring.security.oauth2.client.registration.google")
public class GoogleClientProperties {
	private String clientId;
	private String clientSecret;
	private List<String> scope;
}
