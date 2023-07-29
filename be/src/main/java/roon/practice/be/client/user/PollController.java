package roon.practice.be.client.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.client.user.request.CreatePollRequest;
import roon.practice.be.client.user.request.UpdatePollRequest;
import roon.practice.be.service.CommandGateway;
import roon.practice.be.service.poll.CreatePollCommand;
import roon.practice.be.service.poll.UpdatePollCommand;

@ClientInterface
public class PollController {

	private final CommandGateway commandGateway;

	public PollController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("/create-poll")
	public PollId createPoll(@RequestBody CreatePollRequest request) {
		return commandGateway.send(new CreatePollCommand(request.title(), request.host(), request.selectionList()));
	}

	@PostMapping("/update-poll")
	public PollId updatePoll(@RequestBody UpdatePollRequest request) {
		return commandGateway.send(new UpdatePollCommand(new PollId(request.id()), request.title(), request.host(), request.selectionList()));
	}

}
