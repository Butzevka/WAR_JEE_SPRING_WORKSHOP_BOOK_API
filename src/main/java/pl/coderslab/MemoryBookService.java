package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryBookService implements BookService {

    private Map<Long, Book> bookMap;

    private static Long nextId = 4L;

    @Override
    public List<Book> getAllBooks() {
        return List.copyOf(bookMap.values());
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookMap.get(id));
    }

    @Override
    public void addBook(Book book) {
        if (book.getId() == null) {
            book.setId(nextId);
            nextId++;
        }
        bookMap.put(book.getId(), book);
    }

    @Override
    public void editBook(Book book) {
        bookMap.put(book.getId(), book);
    }

    @Override
    public void deleteBook(Long id) {
        bookMap.remove(id);

    }

}
