package roon.practice.be.service.poll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericHandler;
import org.springframework.integration.dsl.IntegrationFlow;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollRepository;

import static roon.practice.be.service.poll.PollCommandChannels.*;

@Configuration
public class PollCommandFlow {

	private final PollRepository pollRepository;

	public PollCommandFlow(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	@Bean
	public IntegrationFlow createPollFlow() {
		return IntegrationFlow.from(CREATE_POLL_COMMAND.channelName)
				.handle((GenericHandler<?>) (payload, header) -> {
					CreatePollCommand command = (CreatePollCommand) payload;
					Poll poll = new Poll(pollRepository.id(), command.title(), command.host(), command.selectionList());
					return pollRepository.save(poll).getId();
				})
				.get();
	}

	@Bean
	public IntegrationFlow updatePollFlow() {
		return IntegrationFlow.from(UPDATE_POLL_COMMAND.channelName)
				.handle((GenericHandler<?>) (payload, header) -> {
					UpdatePollCommand command = (UpdatePollCommand) payload;
					Poll poll = pollRepository.findById(command.id())
							.orElseThrow(IllegalArgumentException::new);
					return pollRepository.save(poll).getId();
				})
				.get();

	}
}
