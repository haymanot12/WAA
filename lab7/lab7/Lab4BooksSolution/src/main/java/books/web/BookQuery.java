package books.web;

import books.domain.Book;
import books.service.BookService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public List<Book> getBooks(final int count) {
        return bookService.getAllBooks(count);
    }

    public Optional<Book> getBook(final String isbn) {
        return bookService.getBook(isbn);
    }
}
