package books.web;

import books.domain.Book;
import books.service.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookService bookService;

    public Book createBook(final String isbn, final String title, final float price, final String author) {
        return bookService.createBook(isbn, title, price, author);
    }
}
