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
@Document("vote")
public class Vote {

	@Id
	public String id;
	public String voteFormId;
	private List<Option> selectedOptions;
	private LocalDateTime voteAt;

	public Vote(String id, String voteFormId, List<Option> selectedOptions, LocalDateTime voteAt) {
		this.id = id;
		this.voteFormId = voteFormId;
		this.selectedOptions = selectedOptions;
		this.voteAt = voteAt;
	}
}
