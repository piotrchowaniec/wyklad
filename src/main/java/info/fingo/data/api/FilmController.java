package info.fingo.data.api;

import info.fingo.data.FilmRepository;
import info.fingo.data.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("films2")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    public Page<Film> getAll(Pageable page, Sort sort) {
        return filmRepository.findAll(page);
    }
}
