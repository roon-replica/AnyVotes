package roon.practice.be.service;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import roon.practice.be.business.EventThreadLocal;

@Slf4j
@Aspect
@Component
public class CommandHandlerAop {

	private final EventGateway eventGateway;

	public CommandHandlerAop(EventGateway eventGateway) {
		this.eventGateway = eventGateway;
	}

//	@Before("bean(test)")
	@Before("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void before() {
		Optional<TransactionSynchronization> eventsTransactionSynchronization = TransactionSynchronizationManager.getSynchronizations().stream()
				.filter(EventsTransactionSynchronization.class::isInstance)
				.findAny();

		if (eventsTransactionSynchronization.isEmpty()) {
			TransactionSynchronizationManager.registerSynchronization(new EventsTransactionSynchronization(eventGateway));
		}
	}

	private record EventsTransactionSynchronization(EventGateway eventGateway) implements TransactionSynchronization {

		@Override
		public void afterCommit() {
			var event = EventThreadLocal.getEvent();
			if(event != null) eventGateway.send(event);
		}

		@Override
		public void afterCompletion(int status) {
			EventThreadLocal.clear();
		}
	}
}
