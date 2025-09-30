<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CineSphere - Popular Movies</title>
    <style>
        body { font-family: sans-serif; background-color: #141414; color: white; margin: 0; padding: 20px; }
        h1 { text-align: center; }
        #movie-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); gap: 20px; }
        .movie-card { background-color: #222; border-radius: 8px; overflow: hidden; text-align: center; }
        .movie-card img { max-width: 100%; }
        .movie-card h3 { padding: 10px; margin: 0; font-size: 16px; }
    </style>
</head>
<body>

    <h1>Popular Movies</h1>
    <div id="movie-grid"></div>

    <script>
        window.addEventListener('DOMContentLoaded', () => {
            fetch('/api/movies/popular')
                .then(response => response.json())
                .then(data => {
                    const movieGrid = document.getElementById('movie-grid');
                    const movies = data.results;

                    movies.forEach(movie => {
                        const movieCard = document.createElement('div');
                        movieCard.classList.add('movie-card');

                        const posterUrl = `https://image.tmdb.org/t/p/w500${movie.poster_path}`;

                        movieCard.innerHTML = `
                            <img src="${posterUrl}" alt="${movie.title}">
                            <h3>${movie.title}</h3>
                        `;
                        movieGrid.appendChild(movieCard);
                    });
                })
                .catch(error => {
                    console.error('Error:', error);
                    document.getElementById('movie-grid').innerHTML = '<h2>Failed to load movies.</h2>';
                });
        });
    </script>
</body>
</html>