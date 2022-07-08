package uz.demo.roomdb.data.dataSource.database.movielist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MovieEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "original_language")
    val orgLang: String,
    @ColumnInfo(name = "overview")
    val description: String,
    @ColumnInfo(name = "Image")
    val image: String,
    @ColumnInfo(name = "release_date")
    val releasedDate: String

)