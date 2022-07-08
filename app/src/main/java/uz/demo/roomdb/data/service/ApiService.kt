package uz.demo.roomdb.data.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.demo.roomdb.di.response.*

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey : String,
    ): MovieListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey : String,
    ): MovieListResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey : String,
    ): MovieListResponse

    @GET("movie/{movieId}/credits")
    suspend fun getActorList(
        @Path("movieId") movieId : Int,
        @Query("api_key") apiKey: String
    ) :MovieActorListResponse

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey : String
    ): MovieDetailsListResponse
    @GET("person/{personId}")
    suspend fun getActorDetails(
        @Path("personId") personId: Int,
        @Query("api_key") apiKey : String
    ): ActorDetailsResponse

    @GET("person/{personId}/movie_credits")
    suspend fun getKnownMovies(
        @Path("personId") personId: Int,
        @Query("api_key") apiKey: String
    ) : KnownMovieListResponse
}