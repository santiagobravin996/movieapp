package movieapp.repository_domain

import movieapp.data.model.MovieList

interface MovieRepository{
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}