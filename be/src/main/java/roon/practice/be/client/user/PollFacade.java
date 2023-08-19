package roon.practice.be.client.user;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import roon.practice.be.business.exception.ResourceNotFound;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.client.user.response.PollResponse;

@Service
public class PollFacade {

	private final PollRepository pollRepository;

	public PollFacade(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	public List<PollResponse> getPolls(int page, int pageSize) {
		var polls = pollRepository.findAll(PageRequest.of(page, pageSize));
		return polls.stream()
				.map(poll -> new PollResponse(
						poll.getId().toString(), poll.getTitle(), poll.getHost(), poll.getSelectionList(), poll.getStartAt(), poll.getEndAt(),
						poll.isMultiSelectable())
				)
				.toList();
	}

	public PollResponse getPoll(String pollId) {
		return pollRepository.findById(new PollId(pollId))
				.map(poll -> new PollResponse(
						poll.getId().toString(), poll.getTitle(), poll.getHost(), poll.getSelectionList(), poll.getStartAt(), poll.getEndAt(),
						poll.isMultiSelectable())
				)
				.orElseThrow(ResourceNotFound::new);
	}
}
