package roon.practice.be.interfaces.client;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roon.practice.be.interfaces.client.request.CreateSimplePollRequest;
import roon.practice.be.interfaces.client.response.CreatePollResult;
import roon.practice.be.service.CommandGateway;
import roon.practice.be.service.simplepoll.CreateSimplePollCommand;

@ClientInterface
public class SimplePollController {

	private final CommandGateway commandGateway;

	public SimplePollController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("/create-poll")
	public CreatePollResult createPoll(@RequestBody CreateSimplePollRequest request) {
		commandGateway.send(new CreateSimplePollCommand(request.title(), request.host(), request.selectionList()));
		return null;
	}
}
