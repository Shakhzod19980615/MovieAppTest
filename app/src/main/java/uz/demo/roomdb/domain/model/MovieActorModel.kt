package uz.demo.roomdb.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieActorModel(
    val id : Int,
    val name : String,
    val character : String,
    val profile_path : String?,

)