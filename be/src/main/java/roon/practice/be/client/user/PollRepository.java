package roon.practice.be.client.user;

import org.springframework.data.jpa.repository.JpaRepository;
import roon.practice.be.business.poll.Poll;
import roon.practice.be.business.poll.PollId;

public interface PollRepository extends JpaRepository<Poll, PollId> {

}
