package roon.practice.be.config.messaging.event;


import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;
import roon.practice.be.business.Event;
import roon.practice.be.infra.event.EventChannels;

@Slf4j
@Configuration
public class EventConfig {
	public static final String EVENT_GATEWAY_CHANNEL = "EventChannel";

	@Bean(EVENT_GATEWAY_CHANNEL)
	public MessageChannel eventChannel() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow routeEvent() {
		return IntegrationFlow.from(EventChannels.POLL_CREATED_EVENT.channelName)
				.log()
				.channel(channels -> channels.executor(Executors.newCachedThreadPool()))
				.<Event, String>route(event -> event.getClass().getSimpleName(), mapping ->
						mapping.subFlowMapping(EventChannels.POLL_CREATED_EVENT.channelName, sf -> sf.channel(EventChannels.POLL_CREATED_EVENT.channelName))
				).get();
	}
}
