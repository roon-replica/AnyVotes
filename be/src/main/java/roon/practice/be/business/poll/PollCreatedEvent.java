package roon.practice.be.business.poll;

import java.util.List;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.business.Event;

public record PollCreatedEvent(PollId id, String title, String host, List<Selection> selectionList) implements Event {

}
