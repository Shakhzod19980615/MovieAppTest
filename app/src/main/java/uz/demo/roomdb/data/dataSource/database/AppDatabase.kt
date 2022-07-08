package uz.demo.roomdb.data.dataSource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.demo.roomdb.data.dataSource.database.movieDetail.MovieDetailDao
import uz.demo.roomdb.data.dataSource.database.movieDetail.MovieDetailEntity
import uz.demo.roomdb.data.dataSource.database.movielist.MovieDao
import uz.demo.roomdb.data.dataSource.database.movielist.MovieEntity

@Database(entities = [ MovieEntity::class, MovieDetailEntity::class], version = 3,exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
    abstract val movieDetailDao : MovieDetailDao
}