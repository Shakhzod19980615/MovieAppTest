package uz.demo.roomdb.domain.interactor.movie

import uz.demo.roomdb.domain.data.repository.MovieRepository
import uz.demo.roomdb.domain.model.ActorDetailModel
import uz.demo.roomdb.domain.model.MovieActorModel
import uz.demo.roomdb.domain.model.MovieDetailModel
import uz.demo.roomdb.domain.model.MovieModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieInteractorImpl @Inject constructor(
   private val repository: MovieRepository
) : MovieInteractor {

    override suspend fun getMovies(): List<MovieModel> {
            return repository.getMovies()

    }

    override suspend fun getMovieDetail(id : Int): MovieDetailModel? {
        return repository.getMovieDetail(id = id )
    }

    override suspend fun getTopRatedMovies(): List<MovieModel> {
        return repository.getTopRatedMovies()
    }

    override suspend fun getUpcomingMovies(): List<MovieModel> {
        return repository.getUpcomingMovies()
    }

    override suspend fun getActorList(id: Int): List<MovieActorModel> {
        return repository.getActorList(id = id)
    }

    override suspend fun getActorDetail(id: Int): ActorDetailModel? {
        return repository.getActorDetail(id = id)
    }

    override suspend fun getKnownMovies(id: Int): List<MovieModel> {
        return repository.getKnownMovies(id = id)
    }
}