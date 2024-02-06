package roon.practice.be.domain.vote;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document("voteForm")
public class VoteForm {

	@Id
	private String id;
	private String title;
	private String host;
	private LocalDateTime startAt;
	private LocalDateTime endAt;
	private boolean isMultiSelectable;
	private List<Option> options;
	private LocalDateTime createdAt;
	private LocalDateTime lastModifiedAt;

	public VoteForm(String id, String title, String host, List<Option> options, boolean isMultiSelectable,
			LocalDateTime startAt, LocalDateTime endAt) {
		this.id = id;
		this.title = title;
		this.host = host;
		this.options = options;
		this.isMultiSelectable = isMultiSelectable;
		this.startAt = startAt;
		this.endAt = endAt;

		this.createdAt = LocalDateTime.now();
		this.lastModifiedAt = null;
	}

	public void update(String title, String host, List<Option> optionList, LocalDateTime startAt, LocalDateTime endAt,
			boolean isMultiSelectable) {
		this.title = title;
		this.host = host;
		this.options = optionList;
		this.startAt = startAt;
		this.endAt = endAt;
		this.isMultiSelectable = isMultiSelectable;
		this.lastModifiedAt = LocalDateTime.now();
	}
}
