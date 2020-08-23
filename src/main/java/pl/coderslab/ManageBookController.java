package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    @Autowired
    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "/books/list";
    }

    @RequestMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id).get());
        return "/books/form";
    }

    @PostMapping("/edit/{id}")
    public String saveBookForm(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/form";
        }
        bookService.editBook(book);
        return "redirect:/admin/books/list";
    }

    @RequestMapping("/add")
    public String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "/books/form";
    }

    @PostMapping("/add")
    public String saveBookForm(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "books/form";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books/list";
    }

}


