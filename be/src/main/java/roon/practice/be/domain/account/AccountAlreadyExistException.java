package roon.practice.be.domain.account;

public class AccountAlreadyExistException extends RuntimeException {

	private final String message;

	public AccountAlreadyExistException(String message) {
		this.message = message;
	}
}
