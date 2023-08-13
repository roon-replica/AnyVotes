package roon.practice.be.service.poll;

import static roon.practice.be.service.poll.PollCommandChannels.CREATE_POLL_COMMAND;
import static roon.practice.be.service.poll.PollCommandChannels.UPDATE_POLL_COMMAND;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericHandler;
import org.springframework.integration.dsl.IntegrationFlow;
import roon.practice.be.business.poll.Poll;


@Configuration
public class PollCommandFlow {

	private final PollCommandHandler handler;

	public PollCommandFlow(PollCommandHandler handler) {
		this.handler = handler;
	}

	@Bean
	public IntegrationFlow createPollFlow() {
		return IntegrationFlow.from(CREATE_POLL_COMMAND.channelName)
				.handle(handler, "createPoll")
				.get();
	}

	@Bean
	public IntegrationFlow updatePollFlow() {
		return IntegrationFlow.from(UPDATE_POLL_COMMAND.channelName)
				.handle(handler, "updatePoll")
				.get();

	}
}
