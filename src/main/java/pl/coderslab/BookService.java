package pl.coderslab;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    void addBook(Book book);
    void editBook(Book book);
    void deleteBook(Long id);

}
