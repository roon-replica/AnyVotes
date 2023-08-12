package roon.practice.be.business;

public class EventThreadLocal {

	private static final ThreadLocal<Event> event = new ThreadLocal<>();

	private EventThreadLocal() {
		throw new UnsupportedOperationException("Do not Initialize.");
	}

	public static void register(Event event) {
		if (event != null) {
			EventThreadLocal.event.set(event);
		}
	}

	public static Event getEvent(){
		return event.get();
	}

	public static void clear() {
		event.remove();
	}
}