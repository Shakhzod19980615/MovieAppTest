package uz.demo.roomdb.di.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieActorResponse (
    @SerialName("id")
    val id : Int,
    @SerialName("name")
    val name : String,
    @SerialName("character")
    val character : String,
    @SerialName("profile_path")
    val profile_path : String?
)