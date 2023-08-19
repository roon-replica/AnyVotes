package roon.practice.be.client.user;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import roon.practice.be.client.user.response.PollDto;

@Service
public class PollFacade {

	private final PollRepository pollRepository;

	public PollFacade(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	public List<PollDto> getPolls(int page, int pageSize) {
		var polls = pollRepository.findAll(PageRequest.of(page, pageSize));
		return polls.stream()
				.map(poll -> new PollDto(
						poll.getId().toString(), poll.getTitle(), poll.getHost(), poll.getSelectionList(), poll.getStartAt(), poll.getEndAt(),
						poll.isMultiSelectable())
				)
				.toList();
	}
}
