package roon.practice.be.interfaces.client;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roon.practice.be.config.messaging.command.CommandTemplate;
import roon.practice.be.interfaces.client.request.CreateSimplePollRequest;
import roon.practice.be.interfaces.client.response.CreatePollResult;
import roon.practice.be.service.Command;

@ClientInterface
public class SimplePollController {

	private final CommandTemplate commandTemplate;

	public SimplePollController(CommandTemplate commandTemplate) {
		this.commandTemplate = commandTemplate;
	}

	@PostMapping("/create-poll")
	public CreatePollResult createPoll(@RequestBody CreateSimplePollRequest request) {
		commandTemplate.send(new Command(request));
		return null;
	}
}
