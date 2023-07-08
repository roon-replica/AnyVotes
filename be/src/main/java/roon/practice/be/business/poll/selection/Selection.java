package roon.practice.be.business.poll.selection;

import lombok.Getter;

@Getter
public class Selection {

	private final String title;
	private final SelectionType type;
	private final String input;

	public Selection(String title, SelectionType type, String input) {
		this.title = title;
		this.type = type;
		this.input = input;
	}
}
