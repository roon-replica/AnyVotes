package roon.practice.be.business;

import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@MappedSuperclass
public class Id implements Serializable {

	private String id;

	public Id(String id) {
		this.id = id;
	}
}
