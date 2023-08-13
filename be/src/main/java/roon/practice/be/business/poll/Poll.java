package roon.practice.be.business.poll;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import roon.practice.be.business.poll.selection.Selection;
import roon.practice.be.business.EventThreadLocal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Poll {

	@EmbeddedId
	@Column(columnDefinition = "VARCHAR(24)", nullable = false)
	private PollId id;

	@Column(columnDefinition = "VARCHAR(24)", nullable = false)
	private String title;

	@Column(columnDefinition = "VARCHAR(24)", nullable = false)
	private String host;

	@Column(columnDefinition = "DATETIME(6)", nullable = false)
	private LocalDateTime startAt;

	@Column(columnDefinition = "DATETIME(6)", nullable = false)
	private LocalDateTime endAt;

	@Column(columnDefinition = "BOOLEAN", nullable = false)
	private boolean isMultiSelectable;

	@ElementCollection
	@CollectionTable(name = "selection_list", joinColumns = @JoinColumn(name = "id"))
	private List<Selection> selectionList;

	@Column(columnDefinition = "DATETIME(6)", nullable = false)
	private LocalDateTime createdAt;

	@Column(columnDefinition = "DATETIME(6)")
	private LocalDateTime lastModifiedAt;

	public Poll(PollId id, String title, String host, List<Selection> selectionList, LocalDateTime startAt, LocalDateTime endAt,
			boolean isMultiSelectable) {
		this.id = id;
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;
		this.startAt = startAt;
		this.endAt = endAt;
		this.isMultiSelectable = isMultiSelectable;

		this.createdAt = LocalDateTime.now();
		this.lastModifiedAt = null;

		EventThreadLocal.register(new PollCreatedEvent(id, title, host, selectionList, startAt, endAt, isMultiSelectable));
	}

	public void update(String title, String host, List<Selection> selectionList, LocalDateTime startAt, LocalDateTime endAt,
			boolean isMultiSelectable) {
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;
		this.startAt = startAt;
		this.endAt = endAt;
		this.isMultiSelectable = isMultiSelectable;

		this.lastModifiedAt = LocalDateTime.now();

		EventThreadLocal.register(new PollUpdatedEvent(id, title, host, selectionList, startAt, endAt, isMultiSelectable));
	}
}
