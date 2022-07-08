package uz.demo.roomdb.data.mapper

import uz.demo.roomdb.data.common.Constants
import uz.demo.roomdb.data.dataSource.database.movielist.MovieEntity
import uz.demo.roomdb.di.response.*
import uz.demo.roomdb.domain.model.MovieActorModel
import uz.demo.roomdb.domain.model.MovieModel

fun MovieListResponse.mapToMovieModel(): List<MovieModel> {
    return results.map {
        MovieModel(
            id = it.id,
            image = Constants.URL_IMAGE_PREFIX + it.image,
            title = it.title
        )
    }
}
fun MovieEntity.mapToMovieModel() : MovieModel {
    return MovieModel(
        id = id,
        image = image,
        title = title,
    )
}
fun MovieListResponse.mapToMovieEntity(): List<MovieEntity>{
    return results.map {
        MovieEntity(
            id = it.id,
            title = it.title,
            orgLang = it.orgLang,
            description = it.overview,
            image = Constants.URL_IMAGE_PREFIX +  it.image?:"",
            releasedDate = it.releaseDate
        )
    }
}
fun MovieActorListResponse.mapToMovieActorModel(): List<MovieActorModel> {
    return cast.map {
        MovieActorModel(
            id = it.id,
            name = it.name,
            character = it.character,
            profile_path = Constants.URL_IMAGE_PREFIX + it.profile_path?:""
        )
    }
}
fun KnownMovieListResponse.mapToKnownMovieModel(): List<MovieModel>{
    return cast.map {
        MovieModel(
            id = it.id,
            title = it.title,
            image = Constants.URL_IMAGE_PREFIX + it.image?:"",

        )
    }
}


