package uz.demo.roomdb.di.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KnownMovieListResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("cast")
    val cast : List<KnownMovieResponse>
)