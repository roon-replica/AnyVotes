package roon.practice.be.interfaces.client.request;

import java.util.List;
import roon.practice.be.business.poll.selection.Selection;

public record CreateSimplePollRequest(String title, String host, List<Selection> selectionList) {

}
