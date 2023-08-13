package roon.practice.be.business.poll;

import java.time.LocalDateTime;
import java.util.List;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.business.Event;

public record PollUpdatedEvent(PollId id, String title, String host, List<Selection> selectionList, LocalDateTime startAt, LocalDateTime endAt,
							   boolean isMultiSelectable) implements Event {

}
