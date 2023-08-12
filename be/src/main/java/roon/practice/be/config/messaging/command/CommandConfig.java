package roon.practice.be.config.messaging.command;

import static roon.practice.be.service.poll.PollCommandChannels.CREATE_POLL_COMMAND;
import static roon.practice.be.service.poll.PollCommandChannels.UPDATE_POLL_COMMAND;

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

	public static final String COMMAND_GATEWAY_CHANNEL = "CommandChannel";

	@Bean(COMMAND_GATEWAY_CHANNEL)
	public MessageChannel commandChannel() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow routeCommand() {
		return IntegrationFlow.from(commandChannel())
				.log()
				.channel(channels -> channels.executor(Executors.newCachedThreadPool()))
				.<Command, String>route(command -> command.getClass().getSimpleName(), mapping ->
						mapping.subFlowMapping(CREATE_POLL_COMMAND.channelName, sf -> sf.channel(CREATE_POLL_COMMAND.channelName))
								.subFlowMapping(UPDATE_POLL_COMMAND.channelName, sf -> sf.channel(UPDATE_POLL_COMMAND.channelName))
				).get();
	}
}
