package roon.practice.be.service.poll;

import java.util.List;
import lombok.ToString;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.service.Command;

@ToString
public class UpdatePollCommand extends Command {

	public final PollId id;
	public final String title;
	public final String host;
	public final List<Selection> selectionList;

	public UpdatePollCommand(PollId id, String title, String host, List<Selection> selectionList) {
		this.id = id;
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;
	}
}
