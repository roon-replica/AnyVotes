package roon.practice.be.business.poll.selection;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public record Selection(String title,
						SelectionType type,
						String input
) {

}
