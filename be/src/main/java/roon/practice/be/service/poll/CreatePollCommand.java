package roon.practice.be.service.poll;

import java.util.List;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.service.Command;

public record CreatePollCommand(String title, String host, List<Selection> selectionList) implements Command {

}
