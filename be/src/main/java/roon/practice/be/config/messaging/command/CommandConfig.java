package roon.practice.be.config.messaging.command;

import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;
import roon.practice.be.service.Command;

@Slf4j
@Configuration
public class CommandConfig {

	public static final String COMMAND_CHANNEL = "CommandChannel";

	@Bean(COMMAND_CHANNEL)
	public MessageChannel commandChannel() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow routeCommand() {
		return IntegrationFlow.from(commandChannel())
				.log()
				.channel(channels -> channels.executor(Executors.newCachedThreadPool()))
				.<Command, String>route(command -> command.getClass().getSimpleName(), mapping -> mapping.subFlowMapping(
						"CreatePollCommand", sf -> sf.channel("CreatePollCommand"))
				).get();
	}

}
