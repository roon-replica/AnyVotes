package roon.practice.be.client.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.client.user.request.CreatePollRequest;
import roon.practice.be.client.user.request.UpdatePollRequest;
import roon.practice.be.client.user.response.PollDto;
import roon.practice.be.service.CommandGateway;
import roon.practice.be.service.poll.CreatePollCommand;
import roon.practice.be.service.poll.UpdatePollCommand;

@ClientInterface
public class PollController {

	private final CommandGateway commandGateway;
	private final PollFacade pollFacade;

	public PollController(CommandGateway commandGateway, PollFacade pollFacade) {
		this.commandGateway = commandGateway;
		this.pollFacade = pollFacade;
	}

	@PostMapping("/create-poll")
	public PollId createPoll(@RequestBody CreatePollRequest request) {
		return commandGateway.send(new CreatePollCommand(request.title(), request.host(), request.selectionList(), request.startAt(), request.endAt(),
				request.isMultiSelectable())
		);
	}

	@PostMapping("/update-poll")
	public PollId updatePoll(@RequestBody UpdatePollRequest request) {
		return commandGateway.send(
				new UpdatePollCommand(new PollId(request.id()), request.title(), request.host(), request.selectionList(), request.startAt(),
						request.endAt(), request.isMultiSelectable()));
	}

	@GetMapping("/polls")
	public List<PollDto> getPolls(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") @Min(1) @Max(10) int pageSize) {
		return pollFacade.getPolls(page, pageSize);
	}

	@GetMapping("/polls/{pollId}")
	public PollDto getPoll(@PathVariable String pollId) {
		return pollFacade.getPoll(pollId);
	}
}
