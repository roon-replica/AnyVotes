package roon.practice.be.service;

import org.springframework.integration.annotation.MessagingGateway;
import roon.practice.be.config.messaging.command.CommandConfig;

@MessagingGateway(defaultRequestChannel = CommandConfig.COMMAND_CHANNEL)
public interface CommandGateway {

	void send(Command command);

}
