package roon.practice.be.business.poll;

import java.util.Optional;
import roon.practice.be.business.RepositoryOperations;

public abstract class PollRepository implements RepositoryOperations<Poll, PollId> {
	abstract public Optional<Poll> findById(PollId id);
}
