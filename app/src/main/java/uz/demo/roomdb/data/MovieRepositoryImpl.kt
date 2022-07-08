package uz.demo.roomdb.data

import uz.demo.roomdb.data.common.Constants
import uz.demo.roomdb.data.mapper.*
import uz.demo.roomdb.data.service.ApiService
import uz.demo.roomdb.domain.data.repository.MovieRepository
import uz.demo.roomdb.domain.model.ActorDetailModel
import uz.demo.roomdb.domain.model.MovieActorModel
import uz.demo.roomdb.domain.model.MovieDetailModel
import uz.demo.roomdb.domain.model.MovieModel
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getMovies(): List<MovieModel> {
          return try {
                val result = apiService.getPopularMovies(apiKey = Constants.API_KEY)

                result.mapToMovieModel()
            } catch (e: Exception) {
                return emptyList()
            }
        }

    override suspend fun getMovieDetail(id: Int): MovieDetailModel? {
        val result = apiService.getMovieDetails(apiKey = Constants.API_KEY, movieId = id)
        return result.mapToMovieDetailModel()
    }

    override suspend fun getTopRatedMovies(): List<MovieModel> {
        return try {
            val result = apiService.getTopRatedMovies(apiKey = Constants.API_KEY)

            result.mapToMovieModel()
        }catch (e:Exception){
            return emptyList()
        }
    }

    override suspend fun getUpcomingMovies(): List<MovieModel> {
        return try {
            val result = apiService.getUpcomingMovies(apiKey = Constants.API_KEY)
            result.mapToMovieModel()
        } catch (e: Exception) {
            return emptyList()
        }
    }

    override suspend fun getActorList(id: Int): List<MovieActorModel> {
        val result = apiService.getActorList(apiKey = Constants.API_KEY,movieId = id)
        return result.mapToMovieActorModel()
    }

    override suspend fun getActorDetail(id: Int): ActorDetailModel? {
        val result = apiService.getActorDetails(apiKey = Constants.API_KEY,personId = id)
        return result.mapToActorDetail()
    }

    override suspend fun getKnownMovies(id: Int): List<MovieModel> {
        val result = apiService.getKnownMovies(apiKey = Constants.API_KEY, personId = id)
        return result.mapToKnownMovieModel()
    }
}

