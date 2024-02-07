package roon.practice.be.domain.account;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	Optional<Account> findByEmail(String email);

}
