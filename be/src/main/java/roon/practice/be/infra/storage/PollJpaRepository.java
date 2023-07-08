package roon.practice.be.infra.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollId;

public interface PollJpaRepository extends JpaRepository<Poll, PollId> {

}
