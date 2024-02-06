package roon.practice.be.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roon.practice.be.domain.vote.Vote;
import roon.practice.be.interfaces.request.VoteRequest;
import roon.practice.be.service.VoteService;

@ApiInterface
public class VoteController {

	private final VoteService voteService;

	public VoteController(VoteService voteService) {
		this.voteService = voteService;
	}

	@PostMapping("/vote")
	public String vote(@RequestBody VoteRequest req) {
		return voteService.vote(req.voteFormId(), req.selectedOptions(), req.voteAt());
	}

	@GetMapping("/vote/{id}")
	public Vote getVote(@PathVariable String id) {
		return voteService.getVote(id);
	}
}
