package uz.demo.roomdb.data.mapper

import uz.demo.roomdb.data.common.Constants
import uz.demo.roomdb.data.dataSource.database.movieDetail.MovieDetailEntity
import uz.demo.roomdb.di.response.ActorDetailsResponse
import uz.demo.roomdb.di.response.MovieDetailsListResponse
import uz.demo.roomdb.domain.model.ActorDetailModel
import uz.demo.roomdb.domain.model.MovieDetailModel

fun MovieDetailsListResponse.mapToMovieDetailModel(): MovieDetailModel {
    return MovieDetailModel(
        id = id,
        budget = budget,
        title = title,
        voteAverage = voteAverage,
        movieImage = Constants.URL_IMAGE_PREFIX + movieImage?:"",
        overview = overview,
    )
}
fun MovieDetailEntity.mapToMovieDetailModel() : MovieDetailModel {
    return MovieDetailModel(
        id = id,
        title = movieTitle,
        budget = budget,
        overview = overview,
        movieImage = Constants.URL_IMAGE_PREFIX + movieImage?:"",
        voteAverage = voteAverage
    )
}
fun MovieDetailModel.mapToMovieDetailEntity() : MovieDetailEntity {
    return MovieDetailEntity(
        id = id,
        movieTitle = title,
        budget = budget,
        overview = overview,
        movieImage = movieImage?:"",
        voteAverage = voteAverage
    )
}
fun ActorDetailsResponse.mapToActorDetail(): ActorDetailModel{
    return ActorDetailModel(
        id = id,
        name = name,
        birthday = birthday?:"",
        biography = biography,
        place_of_birth = place_of_birth,
        profile_path = Constants.URL_IMAGE_PREFIX + profile_path?:""
    )
}