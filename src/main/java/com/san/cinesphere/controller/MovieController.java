package com.san.cinesphere.controller; // Make sure this package name is correct

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.cinesphere.service.TmdbService;
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/popular")
    public String getPopularMovies(@RequestParam(defaultValue = "1") int page) {
        return tmdbService.getPopularMovies(page);
    }
    @GetMapping("/search")
    public String searchMovies(@RequestParam String query, @RequestParam(defaultValue = "1") int page) {
        return tmdbService.searchMovies(query, page);
    }
    @GetMapping("/{movieId}")
    public String getMovieDetails(@PathVariable int movieId) {
        return tmdbService.getMovieDetails(movieId);
    }
    @GetMapping("/{movieId}/providers")
    public String getMovieProviders(@PathVariable int movieId) {
        return tmdbService.getMovieProviders(movieId);
    }
    @GetMapping("/genres")
    public String getGenres() {
        return tmdbService.getGenres();
    }
    @GetMapping("/discover")
    public String discoverMoviesByGenre(@RequestParam int genreId, @RequestParam(defaultValue = "1") int page) {
        return tmdbService.discoverMoviesByGenre(genreId, page);
    }
    @GetMapping("/{movieId}/credits")
    public String getMovieCredits(@PathVariable int movieId) {
        return tmdbService.getMovieCredits(movieId);
    }
}