package mvc.web;


import java.util.*;
import java.util.stream.Collectors;

import mvc.domain.Book;
import mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookServiceController {
    @Autowired
    private BookService bookService;

	@GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.findByFirstName(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book> (book, HttpStatus.OK);
    }

	@DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book book = bookService.findByFirstName(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn = " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping("/books")
    public ResponseEntity<?> addContact(@RequestBody @Valid Book book, Errors errors) {

        if (errors.hasErrors()) {
            Map<String, Object> fieldError = new HashMap<>();
            List<FieldError> fieldErrors= errors.getFieldErrors();
            for(FieldError error : fieldErrors){
                fieldError.put(error.getField(), error.getDefaultMessage());
            }
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("data", null);
        map.put("status", HttpStatus.BAD_REQUEST);
        map.put("fieldError", fieldError);
        return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
    }

    	bookService.add(book);
        return new ResponseEntity<Book> (book, HttpStatus.OK);
    }

	@PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) {
		bookService.update(book);
		return new ResponseEntity<Book> (book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> searchBooks(@RequestParam(value="author", required = false) String author) {
        Books allbooks = new Books();
        if (author == null){  //get all books
            allbooks.setBooks(bookService.findAll());
        }
        else{ //get books from an certain author
            String authorName = author.substring(1,author.length()-1); //remove quotes form the name
            List<Book> booklist = bookService.findAll().stream().filter(b->b.getAuthor().equals(authorName)).collect(Collectors.toList());
            allbooks.setBooks(booklist);
        }
        return new ResponseEntity<Books> (allbooks, HttpStatus.OK);
    }
}


