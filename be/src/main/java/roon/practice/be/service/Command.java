package roon.practice.be.service;

import lombok.Getter;
import org.springframework.messaging.support.GenericMessage;
import roon.practice.be.interfaces.client.request.Request;

@Getter
public class Command extends GenericMessage<Request> {
	public Command(Request payload) {
		super(payload);
	}
}
