package uz.demo.roomdb.data.dataSource.database.movieDetail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_detail_table")
class MovieDetailEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title")
    val movieTitle: String,
    @ColumnInfo(name = "budget")
    val budget: Int,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "MovieImage")
    val movieImage: String,
    @ColumnInfo(name = "VoteAverage")
    val voteAverage: Double,
)