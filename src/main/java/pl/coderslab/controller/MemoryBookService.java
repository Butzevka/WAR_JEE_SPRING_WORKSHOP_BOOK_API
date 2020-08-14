package pl.coderslab.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L,"9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return new ArrayList<>(list);
    }

    public Book getBook(long id) {
        for (Book book : list) {
            if (book.getId()==id) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        if (book.getId()==null){
            book.setId(nextId);
            nextId++;
        }
        list.add(book);
    }

    public void editBook(Book book) {
        Book bookEdit = getBook(book.getId());
        bookEdit.setIsbn(book.getIsbn());
        bookEdit.setTitle(book.getTitle());
        bookEdit.setAuthor(book.getAuthor());
        bookEdit.setPublisher(book.getPublisher());
        bookEdit.setType(book.getType());
    }

    public void deleteBook(long id) {
        for (Book book : list) {
            if (book.getId()==id) {
                list.remove(book);
            }
        }

    }

}
