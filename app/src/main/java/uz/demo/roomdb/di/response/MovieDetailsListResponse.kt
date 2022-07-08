package uz.demo.roomdb.di.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsListResponse(
    @SerialName("title")
    val title: String,
    @SerialName("id")
    val id : Int,
    @SerialName("budget")
    val budget : Int,
    @SerialName("overview")
    val overview : String,
    @SerialName("poster_path")
    val movieImage : String,
    @SerialName("homepage")
    val homePage: String,
    @SerialName ("vote_average")
    val voteAverage : Double
)
