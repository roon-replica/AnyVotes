package roon.practice.be.service;

import java.util.UUID;

public class IdUtils {

	private IdUtils() {
		throw new IllegalStateException("This is util class");
	}

	public static String generateId() {
		return UUID.randomUUID().toString().substring(0, 6);
	}
}
