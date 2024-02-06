package roon.practice.be.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import roon.practice.be.domain.vote.Option;
import roon.practice.be.domain.vote.VoteForm;
import roon.practice.be.domain.vote.VoteFormRepository;

@Service
public class VoteFormService {

	private final VoteFormRepository voteFormRepository;

	public VoteFormService(VoteFormRepository voteFormRepository) {
		this.voteFormRepository = voteFormRepository;
	}

	public String createVoteForm(String title, String host, List<Option> optionList, boolean isMultiSelectable, LocalDateTime startAt, LocalDateTime endAt) {
		return voteFormRepository.save(new VoteForm(IdUtils.generateId(), title, host, optionList, isMultiSelectable, startAt, endAt))
				.getId();
	}

	public List<VoteForm> getAllVoteForms() {
		return voteFormRepository.findAll();
	}

}
