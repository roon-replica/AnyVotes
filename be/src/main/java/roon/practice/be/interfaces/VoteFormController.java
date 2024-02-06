package roon.practice.be.interfaces;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roon.practice.be.domain.vote.VoteForm;
import roon.practice.be.interfaces.request.CreateVoteFormRequest;
import roon.practice.be.service.VoteFormService;

@ApiInterface
public class VoteFormController {

	private final VoteFormService voteFormService;

	public VoteFormController(VoteFormService voteFormService) {
		this.voteFormService = voteFormService;
	}

	@PostMapping("/create-voteForm")
	public String createVoteForm(@RequestBody CreateVoteFormRequest req) {
		return voteFormService.createVoteForm(req.title(), req.host(), req.optionList(), req.isMultiSelectable(), req.startAt(), req.endAt());
	}

	@GetMapping("/voteForms")
	public List<VoteForm> getVoteForms() {
		return voteFormService.getAllVoteForms();
	}
}
