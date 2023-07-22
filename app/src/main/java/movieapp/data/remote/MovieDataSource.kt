package movieapp.data.remote

import movieapp.application.AppConstants
import movieapp.data.model.MovieList
import movieapp.repository_domain.WebService

class MovieDataSource(private val webService: WebService) {
    suspend fun getUpcomingMovies() : MovieList{
        return webService.getUpcomingMovies(AppConstants.API_KEY)
    }
    suspend fun getTopRatedMovies(): MovieList{
        return webService.getTopRatedMovies(AppConstants.API_KEY)
    }
    suspend fun getPopularMovies() : MovieList{
        return webService.getPopularMovies(AppConstants.API_KEY)
    }
}