package roon.practice.be.service.poll;

import java.time.LocalDateTime;
import java.util.List;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.service.Command;

public record UpdatePollCommand(PollId id, String title, String host, List<Selection> selectionList, LocalDateTime startAt, LocalDateTime endAt,
								boolean isMultiSelectable) implements Command {

}
