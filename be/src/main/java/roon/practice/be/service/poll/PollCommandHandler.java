package roon.practice.be.service.poll;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollRepository;

@Service
public class PollCommandHandler {
	private final PollRepository pollRepository;

	public PollCommandHandler(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	@Transactional
	public void createPoll(Object payload){
		CreatePollCommand command = (CreatePollCommand) payload;
		Poll poll = new Poll(pollRepository.id(), command.title(), command.host(), command.selectionList());
		pollRepository.save(poll).getId();
	}

	@Transactional
	public void updatePoll(Object payload){
		UpdatePollCommand command = (UpdatePollCommand) payload;
		Poll poll = pollRepository.findById(command.id())
				.orElseThrow(IllegalArgumentException::new);
		pollRepository.save(poll).getId();
	}
}
