package roon.practice.be.infra.event;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericHandler;
import org.springframework.integration.dsl.IntegrationFlow;

@Slf4j
@Configuration
public class PollEventFlow {

	@Bean
	public IntegrationFlow handlePostCreatedEvent() {
		return IntegrationFlow.from(EventChannels.POLL_CREATED_EVENT.channelName)
				.handle((GenericHandler<?>) (payload, header) -> {
					log.info("Reached handler for {}, header = {}, payload={}", EventChannels.POLL_CREATED_EVENT.channelName, header, payload);
					return null;
				})
				.get();
	}

	@Bean
	public IntegrationFlow handlePostUpdatedEvent() {
		return IntegrationFlow.from(EventChannels.POLL_UPDATED_EVENT.channelName)
				.handle((GenericHandler<?>) (payload, header) -> {
					log.info("Reached handler for {}, header = {}, payload={}", EventChannels.POLL_UPDATED_EVENT.channelName, header, payload);
					return null;
				})
				.get();
	}
}
