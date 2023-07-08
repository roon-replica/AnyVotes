package roon.practice.be.interfaces.client.request;

import java.util.List;
import lombok.ToString;
import roon.practice.be.business.poll.selection.Selection;

@ToString
public class CreateSimplePollRequest extends Request {

	public final String title;
	public final String host;
	public final List<Selection> selectionList;

	public CreateSimplePollRequest(String title, String host, List<Selection> selectionList) {
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;
	}
}
