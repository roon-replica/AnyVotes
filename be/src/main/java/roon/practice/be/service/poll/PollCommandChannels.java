package roon.practice.be.service.poll;

public enum PollCommandChannels {
	CREATE_POLL_COMMAND("CreatePollCommand"),
	UPDATE_POLL_COMMAND("UpdatePollCommand");

	public final String channelName;

	PollCommandChannels(String channelName) {
		this.channelName = channelName;
	}
}
