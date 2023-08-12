package roon.practice.be.service;

import org.springframework.integration.annotation.MessagingGateway;
import roon.practice.be.business.Event;
import roon.practice.be.config.messaging.event.EventConfig;

@MessagingGateway(defaultRequestChannel = EventConfig.EVENT_GATEWAY_CHANNEL)
public interface EventGateway {

	<T> T send(Event event);
}
