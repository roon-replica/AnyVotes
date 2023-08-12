package roon.practice.be.service;

import org.springframework.integration.annotation.MessagingGateway;
import roon.practice.be.config.messaging.command.CommandConfig;

@MessagingGateway(defaultRequestChannel = CommandConfig.COMMAND_GATEWAY_CHANNEL)
public interface CommandGateway {

	<T> T send(Command command);

}
