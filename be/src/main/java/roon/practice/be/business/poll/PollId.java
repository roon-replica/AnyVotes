package roon.practice.be.business.poll;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import roon.practice.be.business.Id;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PollId extends Id {
	public PollId(String id) {
		super(id);
	}
}
