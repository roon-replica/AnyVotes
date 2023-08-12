package roon.practice.be.service.poll;

import java.util.List;
import lombok.ToString;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.service.Command;

@ToString
public class CreatePollCommand extends Command {

	public final String title;
	public final String host;
	public final List<Selection> selectionList;

	public CreatePollCommand(String title, String host, List<Selection> selectionList) {
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;
	}
}
