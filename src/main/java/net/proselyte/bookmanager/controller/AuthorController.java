package net.proselyte.bookmanager.controller;

import net.proselyte.bookmanager.model.Author;
import net.proselyte.bookmanager.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {
    private AuthorService authorService;

    @Autowired(required = true)
    @Qualifier(value = "authorService")
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public String listAuthors(Model model){
        model.addAttribute("author", new Author());
        model.addAttribute("listAuthors", this.authorService.listAuthors());

        return "authors";
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") Author author){
        if(author.getAuthorId() == 0){
            this.authorService.addAuthor(author);
        }else {
            this.authorService.updateAuthor(author);
        }

        return "redirect:/authors";
    }

    @RequestMapping("/author/remove/{authorId}")
    public String removeAuthor(@PathVariable("authorId") int authorId){
        this.authorService.removeAuthor(authorId);

        return "redirect:/authors";
    }

    @RequestMapping("/author/edit/{authorId}")
    public String editAuthor(@PathVariable("authorId") int authorId, Model model){
        model.addAttribute("author", this.authorService.getAuthorById(authorId));
        model.addAttribute("listAuthors", this.authorService.listAuthors());

        return "authors";
    }

    @RequestMapping("/author/data/{authorId}")
    public String authorData(@PathVariable("authorId") int authorId, Model model){
        model.addAttribute("author", this.authorService.getAuthorById(authorId));

        return "authordata";
    }
}
