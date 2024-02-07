package roon.practice.be.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import roon.practice.be.config.authentication.OAuthAttributes;
import roon.practice.be.domain.account.Account;
import roon.practice.be.domain.account.AccountAlreadyExistException;
import roon.practice.be.domain.account.AccountRepository;

@Slf4j
@Service
public class OAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	private final AccountRepository accountRepository;

	public OAuth2Service(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		var oauth2User = delegate.loadUser(userRequest);

		String registrationId = userRequest.getClientRegistration().getRegistrationId(); // client id랑 뭔 차이?
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oauth2User.getAttributes());

		var account = accountRepository.findByEmail(attributes.getEmail());

		if (account.isEmpty()) {
			accountRepository.save(new Account(registrationId, "google", attributes.getEmail()));
		} else {
			log.info("account already exists");
		}

		return oauth2User;
	}
}
