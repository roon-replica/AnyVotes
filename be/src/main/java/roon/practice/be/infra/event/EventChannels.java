package roon.practice.be.infra.event;

public enum EventChannels {
	POLL_CREATED_EVENT("PollCreatedEvent"),
	POLL_UPDATED_EVENT("PollUpdatedEvent");

	public final String channelName;

	EventChannels(String channelName) {
		this.channelName = channelName;
	}
}
