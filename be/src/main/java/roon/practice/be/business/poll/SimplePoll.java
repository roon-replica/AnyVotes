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

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class SimplePoll {
	@EmbeddedId
	@Column(columnDefinition = "VARCHAR(24)", nullable = false)
	private SimplePollId id;

	@Column(columnDefinition = "VARCHAR(24)", nullable = false)
	private String title;

	@Column(columnDefinition = "VARCHAR(24)", nullable = false)
	private String host;

	@ElementCollection
	@CollectionTable(name = "selection_list", joinColumns = @JoinColumn(name="id"))
	private List<Selection> selectionList;
}
