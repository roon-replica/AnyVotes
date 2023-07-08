package roon.practice.be.config.messaging.command;

import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;
import roon.practice.be.interfaces.client.request.Request;

@Slf4j
@Configuration
public class CommandConfig {

	private static final String REQUEST_SUFFIX = "Request";

	@Bean
	public MessageChannel commandChannel() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow routeCommand() {
		return IntegrationFlow.from(commandChannel())
				.log()
				.channel(channels -> channels.executor(Executors.newCachedThreadPool()))
				.<Request, String>route(payload -> {
							var commandRequestClassName = payload.getClass().getSimpleName();
							var commandRequestName = commandRequestClassName.substring(0, commandRequestClassName.lastIndexOf(REQUEST_SUFFIX));
							log.info("commandRequestName : {}", commandRequestName);

							return commandRequestName;
						}, mapping -> mapping.subFlowMapping(
								"CreateSimplePoll", sf -> sf.channel(channels -> channels.queue(10))
										.publishSubscribeChannel(consumer -> consumer
												.subscribe(sf2 -> sf2.handle(message -> log.info("[subscriber-1] message={}", message)))
												.subscribe(sf2 -> sf2.handle(message -> log.info("[subscriber-2] message={}", message)))
										))
				).get();
	}
}
