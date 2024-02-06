package roon.practice.be.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import roon.practice.be.domain.vote.Option;
import roon.practice.be.domain.vote.ResourceNotFoundException;
import roon.practice.be.domain.vote.Vote;
import roon.practice.be.domain.vote.VoteRepository;

@Service
public class VoteService {

	private final VoteRepository voteRepository;

	public VoteService(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}

	public String vote(String voteFormId, List<Option> selectedOptions, LocalDateTime voteAt) {
		return voteRepository.save(new Vote(IdUtils.generateId(), voteFormId, selectedOptions, voteAt))
				.getId();
	}

	public Vote getVote(String id) {
		return voteRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}
}
