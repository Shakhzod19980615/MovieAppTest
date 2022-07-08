package uz.demo.roomdb.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.demo.roomdb.domain.interactor.movie.MovieInteractor
import uz.demo.roomdb.domain.model.MovieDetailModel
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieInteractor: MovieInteractor
) : ViewModel() {

    private val movieDetailLiveData_ : MutableLiveData<MovieDetailModel?> = MutableLiveData<MovieDetailModel?>()
    val movieDetailLiveData : MutableLiveData<MovieDetailModel?> = movieDetailLiveData_

    fun getMovieDetail(id : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = movieInteractor.getMovieDetail(id = id)
                movieDetailLiveData_.postValue(result)
            }
        }
    }
}