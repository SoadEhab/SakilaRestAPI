package gov.iti.jets.web.persistence.dao;

import gov.iti.jets.web.entities.*;

import java.util.List;

public class FilmDao extends SakilaContext {

    public List<Film> getFilmsByLanguage(int langId) {
        Language language = getById(Language.class, langId);
        return language.getFilmList().stream().toList();
    }

    public List<Film> getFilmsByOriginalLanguage(int langId) {
        Language language = getById(Language.class, langId);
        return language.getFilmList1().stream().toList();
    }

    public List<Film> getFilmsByActorName(String name) {
        List<Film> allFilms = getAll("Film.findAll");
        List<Film> films = allFilms.stream()
                .filter(film -> film.getFilmActorList().stream()
                        .anyMatch(filmActor -> filmActor.getActor().getFirstName().contains(name)
                                || filmActor.getActor().getLastName().contains(name))).toList();
        return films;
    }

    public List<Film> getFilmsByCategory(int categoryId) {
        Category category = getById(Category.class, categoryId);
        return category.getFilmCategoryList().stream()
                .map(FilmCategory::getFilm).toList();
    }

    public List<Category> getFilmCategories(int filmId) {
        Film film = getById(Film.class, filmId);
        return film.getFilmCategoryList().stream()
                .map(FilmCategory::getCategory).toList();
    }

    public List<Actor> getFilmActors(int filmId) {
        Film film = getById(Film.class, filmId);
        return film.getFilmActorList().stream()
                .map(FilmActor::getActor).toList();
    }

    public List<Inventory> getFilmInventories(int filmId) {
        Film film = getById(Film.class, filmId);
        return film.getInventoryList().stream().toList();
    }
}
