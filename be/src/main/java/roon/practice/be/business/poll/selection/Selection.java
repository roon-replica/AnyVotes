package roon.practice.be.business.poll.selection;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Selection {

	private String title;
	private SelectionType type;
	private String input;

	public Selection(String title, SelectionType type, String input) {
		this.title = title;
		this.type = type;
		this.input = input;
	}
}
