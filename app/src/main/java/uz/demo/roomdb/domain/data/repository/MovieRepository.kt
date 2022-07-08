package uz.demo.roomdb.domain.data.repository

import uz.demo.roomdb.domain.model.ActorDetailModel
import uz.demo.roomdb.domain.model.MovieActorModel
import uz.demo.roomdb.domain.model.MovieDetailModel
import uz.demo.roomdb.domain.model.MovieModel

interface MovieRepository {

    suspend fun getMovies() : List<MovieModel>
    suspend fun getMovieDetail(id:Int):MovieDetailModel?

    suspend fun getTopRatedMovies() : List<MovieModel>
    suspend fun getUpcomingMovies() : List<MovieModel>
    suspend fun getActorList(id: Int) : List<MovieActorModel>
    suspend fun getActorDetail(id: Int) : ActorDetailModel?
    suspend fun getKnownMovies(id: Int) : List<MovieModel>
}
