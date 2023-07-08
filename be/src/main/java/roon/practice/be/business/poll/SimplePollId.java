package roon.practice.be.business.poll;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import roon.practice.be.business.Id;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SimplePollId extends Id {
	public SimplePollId(String id) {
		super(id);
	}
}
