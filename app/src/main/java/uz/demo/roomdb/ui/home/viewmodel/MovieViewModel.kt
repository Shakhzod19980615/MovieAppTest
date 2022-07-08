package uz.demo.roomdb.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.demo.roomdb.domain.interactor.movie.MovieInteractor
import uz.demo.roomdb.domain.model.MovieModel
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieInteractor: MovieInteractor
) : ViewModel() {

    private val moviesLiveData_ : MutableLiveData<List<MovieModel>>
    =  MutableLiveData<List<MovieModel>>()
    //Encapsulation of MutableLiveData to LiveDate
    //from outside it looks like LiveData but from inside it is MutableLiveData
    val moviesLiveData : LiveData<List<MovieModel>> = moviesLiveData_

    private val topRatedLiveData_ : MutableLiveData<List<MovieModel>>
    = MutableLiveData<List<MovieModel>>()
    val topRatedLiveData : LiveData<List<MovieModel>> = topRatedLiveData_

    private val upcomingMovieLiveData_ : MutableLiveData<List<MovieModel>>
    = MutableLiveData<List<MovieModel>>()
    val upcomingMovieLiveData : LiveData<List<MovieModel>> = upcomingMovieLiveData_

    private val knownMoviesLiveData_ : MutableLiveData<List<MovieModel>>
    = MutableLiveData<List<MovieModel>>()
    val knownMoviesLiveData : LiveData<List<MovieModel>> = knownMoviesLiveData_

       fun getMovie() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
               val result = movieInteractor.getMovies()
                moviesLiveData_.postValue(result)
            }
        }
    }

    fun getTopRatedMovie(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = movieInteractor.getTopRatedMovies()
                topRatedLiveData_.postValue(result)
            }
        }
    }

    fun getUpcomingMovie(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = movieInteractor.getUpcomingMovies()
                upcomingMovieLiveData_.postValue(result)
            }
        }
    }

    fun getKnownMovies(id : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = movieInteractor.getKnownMovies(id = id)
                knownMoviesLiveData_.postValue(result)
            }
        }
    }
}