package net.proselyte.bookmanager.controller;

import net.proselyte.bookmanager.model.Genre;
import net.proselyte.bookmanager.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenreController {
    private GenreService genreService;

    @Autowired(required = true)
    @Qualifier(value = "genreService")
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(value = "genres", method = RequestMethod.GET)
    public String listGenres(Model model){
        model.addAttribute("genre", new Genre());
        model.addAttribute("listGenres", this.genreService.listGenres());

        return "genres";
    }

    @RequestMapping(value = "/genres/add", method = RequestMethod.POST)
    public String addGenre(@ModelAttribute("genre") Genre genre){
        if(genre.getGenreId() == 0){
            this.genreService.addGenre(genre);
        }else {
            this.genreService.updateGenre(genre);
        }

        return "redirect:/genres";
    }

    @RequestMapping("/genre/remove/{genreId}")
    public String removeGenre(@PathVariable("genreId") int genreId){
        this.genreService.removeGenre(genreId);

        return "redirect:/genres";
    }

    @RequestMapping("/genre/edit/{genreId}")
    public String editGenre(@PathVariable("genreId") int genreId, Model model){
        model.addAttribute("genre", this.genreService.getGenreById(genreId));
        model.addAttribute("listGenres", this.genreService.listGenres());

        return "genres";
    }

    @RequestMapping("genredata/{genreId}")
    public String genreData(@PathVariable("genreId") int genreId, Model model){
        model.addAttribute("genre", this.genreService.getGenreById(genreId));

        return "genredata";
    }
}
