package roon.practice.be.service.poll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.integration.core.GenericHandler;
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
				.handle((GenericHandler<?>) (payload, header) -> {
					CreatePollCommand command = (CreatePollCommand) payload;
					Poll poll = new Poll(pollRepository.id(), command.title, command.host, command.selectionList);
					return pollRepository.save(poll).getId();
				})
				.get();
	}

	@Bean
	public IntegrationFlow updatePollFlow() {
		return IntegrationFlow.from("UpdatePollCommand")
				.handle((GenericHandler<?>) (payload, header) -> {
					UpdatePollCommand command = (UpdatePollCommand) payload;
					Poll poll = pollRepository.findById(command.id)
							.orElseThrow(IllegalArgumentException::new);
					return pollRepository.save(poll).getId();
				})
				.get();

	}
}
