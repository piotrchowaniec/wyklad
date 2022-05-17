package info.fingo.data;

import info.fingo.data.entity.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
}
