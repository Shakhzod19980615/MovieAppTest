package uz.demo.roomdb.di.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("title")
    val title : String,
    @SerialName("original_language")
    val orgLang : String,
    @SerialName("poster_path")
    val image : String,
    @SerialName("overview")
    val overview : String,
    @SerialName("release_date")
    val releaseDate : String
)
