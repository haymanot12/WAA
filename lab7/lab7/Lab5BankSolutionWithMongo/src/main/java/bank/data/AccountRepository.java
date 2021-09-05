package bank.data;

import bank.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface AccountRepository extends MongoRepository<Account, Integer> {

}
