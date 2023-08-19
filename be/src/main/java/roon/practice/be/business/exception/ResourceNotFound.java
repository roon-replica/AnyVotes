package roon.practice.be.business.exception;

public class ResourceNotFound extends RuntimeException {

	public ResourceNotFound() {
	}

	public ResourceNotFound(String message) {
		super(message);
	}

	public ResourceNotFound(Throwable cause) {
		super(cause);
	}
}
