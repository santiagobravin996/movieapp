package movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import movieapp.core.Resource

class MovieViewModel : ViewModel() {
    fun fetchUpcomingMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getUpcomingMovies))
        }catch (e: Exception) {
            emit(Resource.Failure(e))
        }

    }
}