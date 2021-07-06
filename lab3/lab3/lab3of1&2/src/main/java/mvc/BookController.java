package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BookController {

    private Map<String, Book> books = new HashMap<String, Book>();

    public BookController() {
        books.put("A7474", new Book("A7474", "Brown", "Atlas", 23416.0));
        books.put("A627363", new Book("A627363", "Jones", "Fountain", 23416.0));
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getContact(@PathVariable String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    @GetMapping("/books/search/")
    public ResponseEntity<?> searchByAuthor(@RequestParam(value="author", required=false) String author){
        List<Book> book = new ArrayList<>();
        //books.forEach();
        for(Book b : books.values()){
            if(b.getAuthor().equals(author)){
                book.add(b);
            }

        }
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with Author= "
                    + author + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List>(book, HttpStatus.OK);
    }


    @PostMapping("/books")
    public ResponseEntity<?> addContact(@RequestBody Book book) {
        books.put(book.getIsbn(), book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteContact(@PathVariable String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with ISBN= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        books.remove(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateContact(@PathVariable String isbn, @RequestBody Book book) {
        books.put(isbn, book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllContacts() {
        Books allbooks = new Books(books.values());
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }
}
