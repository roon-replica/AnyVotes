package roon.practice.be.service.poll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollRepository;

@Configuration
public class PollCommandFlow {

	private final PollRepository pollRepository;

	public PollCommandFlow(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	@Bean
	public IntegrationFlow createPollFlow() {
		return IntegrationFlow.from("CreatePollCommand")
				.handle(message -> {
					CreatePollCommand command = (CreatePollCommand) message.getPayload();
					Poll poll = new Poll(pollRepository.id(), command.title, command.host, command.selectionList);
					pollRepository.save(poll);
				})
				.get();
	}
}
