package nye.progkor.beadando_film_katalogus.Web.controller;

import nye.progkor.beadando_film_katalogus.Data.model.Filmek;
import nye.progkor.beadando_film_katalogus.Service.FilmekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller for film catalogus.
 */

@Controller
@RequestMapping("/templates")
public class FilmCatalogusController {

    private final FilmekService filmekService;

    @Autowired
    public FilmCatalogusController(FilmekService filmekService) {
        this.filmekService = filmekService;
    }

    @GetMapping("/{id}")
    public String getFilmekById(Model model, @PathVariable Long id) {
        Filmek filmek= filmekService.retrieveFilmekById(id);
        model.addAttribute("filmek", filmek);
        return "templates/edit";
    }

    @GetMapping
    public String getAllFilmek(Model model) {
        List<Filmek> allFilmek = filmekService.retrieveAllFilmek();
        model.addAttribute("filmek", allFilmek);
        return "templates/list";
    }


    @GetMapping("/create")
    public String createFilmek() {
        return "templates/create";
    }



    @PostMapping("/create")
    public String createFilmek(Model model, Filmek filmek) {
        Filmek newFilmek = filmekService.createFilmek(filmek);
        model.addAttribute("filmek", newFilmek);
        return "templates/edit";
    }


    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateFilmek(Model model, Filmek filmek) {
        Filmek updatedFilmek = filmekService.updateFilmek(filmek);
        model.addAttribute("filmek", updatedFilmek);
        return "templates/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteFilmekById(Model model, @PathVariable Long id) {
        filmekService.deleteFilmekById(id);
        List<Filmek> allFilmek = filmekService.retrieveAllFilmek();
        model.addAttribute("konyvek", allFilmek);
        return "templates/list";
    }




}


