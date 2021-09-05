package books.service;

import books.data.BookRepository;
import books.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;


   public void add(Book book){
        bookRepository.save(book);
    }

    public void update(Book book){
        bookRepository.save(book);
    }

    public Book findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public void delete(String isbn){
        bookRepository.delete(isbn);
    }

    public Collection<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(String isbn) {
        return  Optional.of(bookRepository.findByIsbn(isbn));
    }

    public List<Book> getAllBooks(int count) {
        List<Book> bookList  = bookRepository.findAll().stream().collect(Collectors.toList());
        return bookList.subList(0,count);
    }

    public Book createBook(String isbn, String title, float price, String author) {
        Book book = new Book(isbn, title, price, author);
        bookRepository.save(book);
        return book;
    }
}
