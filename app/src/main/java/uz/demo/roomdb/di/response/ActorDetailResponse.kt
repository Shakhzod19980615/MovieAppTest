package uz.demo.roomdb.di.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorDetailsResponse(
    @SerialName("id")
    val id : Int,
    @SerialName("name")
    val name : String,
    @SerialName("birthday")
    val birthday : String?,
    @SerialName("biography")
    val biography : String,
    @SerialName ("place_of_birth")
    val place_of_birth : String,
    @SerialName("profile_path")
    val profile_path : String?
)