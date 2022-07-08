package uz.demo.roomdb.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.demo.roomdb.di.viewmodel.ViewModelKey
import uz.demo.roomdb.domain.interactor.movie.MovieInteractor
import uz.demo.roomdb.domain.model.MovieActorModel
import java.util.*
import javax.inject.Inject

class MovieActorListViewModel @Inject constructor(
    private val movieInteractor: MovieInteractor
    ) : ViewModel(){

     private val actorListLiveData_ : MutableLiveData<List<MovieActorModel>>
     = MutableLiveData<List<MovieActorModel>>()
    val actorListLivedata : LiveData<List<MovieActorModel>> = actorListLiveData_

    fun getActorList(id : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = movieInteractor.getActorList(id = id)
                actorListLiveData_.postValue(result)
            }
        }
    }
}