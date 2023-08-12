package roon.practice.be.business.poll;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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

	@ElementCollection
	@CollectionTable(name = "selection_list", joinColumns = @JoinColumn(name = "id"))
	private List<Selection> selectionList;

	public Poll(PollId id, String title, String host, List<Selection> selectionList) {
		this.id = id;
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;

		EventThreadLocal.register(new PollCreatedEvent(id, title, host, selectionList));
	}

	public void update(String title, String host, List<Selection> selectionList){
		this.title = title;
		this.host = host;
		this.selectionList = selectionList;

		EventThreadLocal.register(new PollUpdatedEvent(id, title, host, selectionList));
	}
}
