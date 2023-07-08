package roon.practice.be.service.simplepoll;

import java.util.List;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.service.Command;

public class CreateSimplePollCommand extends Command {
	public final String title;
	public final String host;
	public final List<Selection> selectionList;

	public CreateSimplePollCommand(String title, String host, List<Selection> selectionList) {
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;
	}
}
