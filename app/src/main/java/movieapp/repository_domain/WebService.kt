package movieapp.repository_domain

import com.google.gson.GsonBuilder
import movieapp.application.AppConstants
import movieapp.application.AppConstants.API_KEY
import movieapp.application.AppConstants.URL_BASE
import movieapp.data.model.MovieList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("$URL_BASE/movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey:String) : MovieList
    @GET("$URL_BASE/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey:String): MovieList
    @GET("$URL_BASE/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String): MovieList
}

object RetrofitClient{
    val webservice by lazy{
        Retrofit.Builder()
            .baseUrl(AppConstants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                //para convertir los datos que lleguen en ns objeto segun el modelo.
            .build().create(WebService::class.java)
    }
}