package persons;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;


@RestController
public class PersonController {
	@Autowired
    private PersonRepository personRepository;
	private int x = 10;
	private String id="6734";
	private String text="hjah";

	@PostMapping(value = "/form", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Message> create(@RequestParam(value="id") String idd,
								@RequestParam(value="text") String textt){
		id=idd;
		text=textt;
		System.out.println("Id = "+id);
		System.out.println("Text = "+text);


		return personRepository.findById(id);
	}



    
	@Scheduled(fixedRate = 3000)
	private void savePerson() {
		personRepository.save(new Message(text,id)).block();
		x++;
	}

}
