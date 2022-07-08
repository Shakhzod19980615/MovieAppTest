package uz.demo.roomdb.data.dataSource.database.movielist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentity")
    suspend fun getAll():List<MovieEntity>

    @Query("SELECT title, * FROM movieentity")
    suspend fun getTitle():List<MovieEntity>

    @Insert
    suspend fun insertAll(movies: List<MovieEntity>)

    @Delete
    suspend fun delete(movie: MovieEntity)
}