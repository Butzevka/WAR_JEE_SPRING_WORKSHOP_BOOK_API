package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> readAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book readById(@PathVariable Long id){
        return bookService.getBookById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("")
    public void editBook(@RequestBody Book book) {
        bookService.editBook(book);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

}
