package roon.practice.be.config.messaging.command;

import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import roon.practice.be.service.Command;

@Component
public class CommandTemplate {

	private static final long TIME_OUT_MILLIS = 3000;
	private final MessageChannel commandChannel;

	public CommandTemplate(MessageChannel commandChannel) {
		this.commandChannel = commandChannel;
	}

	public void send(Command command) {
		commandChannel.send(command, TIME_OUT_MILLIS);
	}
}
