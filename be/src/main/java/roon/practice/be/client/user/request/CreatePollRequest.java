package roon.practice.be.client.user.request;

import java.time.LocalDateTime;
import java.util.List;
import roon.practice.be.business.poll.selection.Selection;

public record CreatePollRequest(String title, String host, List<Selection> selectionList, LocalDateTime startAt, LocalDateTime endAt,
								boolean isMultiSelectable) {

}
