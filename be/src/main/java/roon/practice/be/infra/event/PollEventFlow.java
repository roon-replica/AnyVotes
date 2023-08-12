package roon.practice.be.infra.event;


import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import roon.practice.be.business.Event;

@Configuration
public class PollEventFlow {

	@Bean
	public IntegrationFlow handlePostCreatedEvent() {
		return IntegrationFlow.from(EventChannels.POLL_CREATED_EVENT.channelName)
				.log()
				.channel(channels -> channels.executor(Executors.newCachedThreadPool()))
				.<Event, String>route(event -> event.getClass().getSimpleName(), mapping ->
						mapping.subFlowMapping(EventChannels.POLL_CREATED_EVENT.channelName, sf -> sf.channel(EventChannels.POLL_CREATED_EVENT.channelName))
				).get();

	}
}
