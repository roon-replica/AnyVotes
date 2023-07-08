package roon.practice.be.business.poll.selection;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import roon.practice.be.business.Id;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SelectionId extends Id {

	public SelectionId(String id) {
		super(id);
	}
}
