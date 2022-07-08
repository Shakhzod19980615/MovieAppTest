package uz.demo.roomdb.di.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieActorListResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("cast")
    val cast : List<MovieActorResponse>

)