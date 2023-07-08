package roon.practice.be.client.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roon.practice.be.client.user.request.CreatePollRequest;
import roon.practice.be.client.user.response.CreatePollResult;
import roon.practice.be.service.CommandGateway;
import roon.practice.be.service.poll.CreatePollCommand;

@ClientInterface
public class PollController {

	private final CommandGateway commandGateway;

	public PollController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("/create-poll")
	public CreatePollResult createPoll(@RequestBody CreatePollRequest request) {
		commandGateway.send(new CreatePollCommand(request.title(), request.host(), request.selectionList()));
		return null;
	}
}
