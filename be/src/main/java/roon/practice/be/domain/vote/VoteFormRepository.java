package roon.practice.be.domain.vote;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteFormRepository extends MongoRepository<VoteForm, String> {

}
