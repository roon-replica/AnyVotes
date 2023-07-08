package roon.practice.be.infra.data;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollId;
import roon.practice.be.business.poll.PollRepository;

@Repository
public class PollRepositoryImpl extends PollRepository {

	private final PollJpaRepository pollJpaRepository;

	public PollRepositoryImpl(PollJpaRepository pollJpaRepository) {
		this.pollJpaRepository = pollJpaRepository;
	}

	@Override
	public PollId id() {
		return new PollId(UUID.randomUUID().toString());
	}

	@Override
	public Poll save(Poll poll) {
		return pollJpaRepository.save(poll);
	}

	@Override
	public void delete(Poll poll) {
		pollJpaRepository.delete(poll);
	}
}
