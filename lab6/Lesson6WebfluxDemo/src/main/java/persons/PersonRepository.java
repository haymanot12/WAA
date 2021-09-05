package persons;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;


@Repository
public interface PersonRepository extends ReactiveCrudRepository<Message, String>{
	@Tailable
	Mono<Message> findById(String id);
}
