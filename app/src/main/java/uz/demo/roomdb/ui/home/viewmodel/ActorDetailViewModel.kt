package uz.demo.roomdb.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.demo.roomdb.domain.interactor.movie.MovieInteractor
import uz.demo.roomdb.domain.model.ActorDetailModel
import uz.demo.roomdb.domain.model.MovieDetailModel
import javax.inject.Inject

class ActorDetailViewModel @Inject constructor(
    private val movieInteractor: MovieInteractor
) : ViewModel(){
    private val actorDetailLiveData_ : MutableLiveData<ActorDetailModel?> = MutableLiveData<ActorDetailModel?>()
    val actorDetailLiveData : MutableLiveData<ActorDetailModel?> = actorDetailLiveData_

    fun getActorDetail(id : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = movieInteractor.getActorDetail(id = id)
                actorDetailLiveData_.postValue(result)
            }
        }
    }
}