package roon.practice.be.client.user.response;

import java.time.LocalDateTime;
import java.util.List;
import roon.practice.be.business.poll.selection.Selection;

public record PollDto(String id, String title, String host, List<Selection> selectionList, LocalDateTime startAt, LocalDateTime endAt,
					  boolean isMultiSelectable) {
}
