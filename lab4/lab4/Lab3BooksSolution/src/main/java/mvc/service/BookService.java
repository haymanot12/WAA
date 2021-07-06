package mvc.service;

import mvc.data.BookRepository;
import mvc.domain.Book;
import mvc.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EmailSender emailSender;

    public void add(Book book){
        bookRepository.save(book);
        emailSender.sendEmail(book.getAuthor(), "Welcome");
    }

    public void update(Book book){
        bookRepository.save(book);
    }

    public Book findByFirstName(String isbn){
        return bookRepository.findByFirstName(isbn);
    }

    public void delete(String isbn){
        Book book = bookRepository.findByFirstName(isbn);
        emailSender.sendEmail(book.getAuthor(), "Good By");
        bookRepository.delete(isbn);
    }

    public Collection<Book> findAll(){
        return bookRepository.findAll();
    }
}
