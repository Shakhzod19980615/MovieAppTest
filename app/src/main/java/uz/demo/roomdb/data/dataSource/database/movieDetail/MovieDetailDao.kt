package uz.demo.roomdb.data.dataSource.database.movieDetail

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDetailDao {
    @Query("SELECT * FROM movie_detail_table WHERE id=:id")
    suspend fun getMovieDetail(id: Int): MovieDetailEntity?
    @Insert
    suspend fun insertMovieDetail(movieDetailEntity: MovieDetailEntity)
}