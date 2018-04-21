package net.proselyte.bookmanager.controller;

import net.proselyte.bookmanager.model.Book;
import net.proselyte.bookmanager.model.ViewAllBook;
import net.proselyte.bookmanager.service.AuthorService;
import net.proselyte.bookmanager.service.BookService;
import net.proselyte.bookmanager.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private AuthorService authorService;

    @Autowired(required = true)
    @Qualifier(value = "authorService")
    public void setAuthorService(AuthorService AuthorService) {
        this.authorService = AuthorService;
    }

    private GenreService genreService;

    @Autowired(required = true)
    @Qualifier(value = "genreService")
    public void setGenreService(GenreService GenreService) {
        this.genreService = GenreService;
    }


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model){
        List<ViewAllBook> list =  this.bookService.listBooks();
        System.out.println(list.size());
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", list);
        model.addAttribute("listAuthors", this.authorService.listAuthors());
        model.addAttribute("listGenres", this.genreService.listGenres());
        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getBookId() == 0){
            this.bookService.addBook(book);
        }else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/book/remove/{bookId}")
    public String removeBook(@PathVariable("bookId") int bookId){
        this.bookService.removeBook(bookId);

        return "redirect:/books";
    }

    @RequestMapping("/book/edit/{bookId}")
    public String editBook(@PathVariable("bookId") int bookId, Model model){
        model.addAttribute("book", this.bookService.getBookById(bookId));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping("/book/bookdata/{bookId}")
    public String bookData(@PathVariable("bookId") int bookId, Model model){
        model.addAttribute("book", this.bookService.getBookById(bookId));

        return "bookdata";
    }
}
