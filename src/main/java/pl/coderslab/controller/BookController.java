package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MemoryBookService memoryBookService;

    @GetMapping("")
    public List<Book> readAll() {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book readById(@PathVariable int id){
        return memoryBookService.getBook(id);
    }

    @DeleteMapping(path="/{id}")
    public void deleteBook(@PathVariable long id) {
        memoryBookService.deleteBook(id);
    }

    @PutMapping(path="")
    public void editBook(@RequestBody Book book) {
        memoryBookService.editBook(book);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        memoryBookService.addBook(book);
    }

    //    @RequestMapping("/helloBook")
//    public Book helloBook() {
//        return new Book(1L, "9788324631766", "Thinking in Java",
//                "Bruce Eckel", "Helion", "programming");
//    }
}
