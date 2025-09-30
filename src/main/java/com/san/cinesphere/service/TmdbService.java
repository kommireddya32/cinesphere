package com.san.cinesphere.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    // --- MODIFIED METHOD ---
    public String getPopularMovies(int page) {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&page=" + page;
        return restTemplate.getForObject(url, String.class);
    }

    // --- MODIFIED METHOD ---
    public String searchMovies(String query, int page) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + query + "&page=" + page;
        return restTemplate.getForObject(url, String.class);
    }

    public String getMovieDetails(int movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String getMovieProviders(int movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/watch/providers?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
    public String getGenres() {
        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
    public String discoverMoviesByGenre(int genreId, int page) {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&with_genres=" + genreId + "&page=" + page;
        return restTemplate.getForObject(url, String.class);
    }
}