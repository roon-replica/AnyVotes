package roon.practice.be.service.poll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.business.poll.PollRepository;

@Slf4j
@Service
public class PollCommandHandler {

	private final PollRepository pollRepository;

	public PollCommandHandler(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	@Transactional
	public PollId createPoll(Object payload) {
		log.info("[createPoll] payload={}", payload);

		CreatePollCommand command = (CreatePollCommand) payload;
		Poll poll = new Poll(pollRepository.id(), command.title(), command.host(), command.selectionList());
		return pollRepository.save(poll).getId();
	}

	@Transactional
	public PollId updatePoll(Object payload) {
		log.info("[updatePoll] payload={}", payload);

		UpdatePollCommand command = (UpdatePollCommand) payload;
		Poll poll = pollRepository.findById(command.id())
				.orElseThrow(IllegalArgumentException::new);
		return pollRepository.save(poll).getId();
	}
}
