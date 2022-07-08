package uz.demo.roomdb.di.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KnownMovieResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("title")
    val title : String,
    @SerialName("poster_path")
    val image : String?,
    @SerialName("overview")
    val overview : String,

)