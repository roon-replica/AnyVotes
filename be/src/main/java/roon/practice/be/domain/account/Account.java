package roon.practice.be.domain.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document("account")
public class Account {

	@Id
	public String id;
	private String provider;
	private String email;

	public Account(String id, String provider, String email) {
		this.id = id;
		this.provider = provider;
		this.email = email;
	}

}
