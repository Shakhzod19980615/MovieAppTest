package uz.demo.roomdb.di.room

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.demo.roomdb.data.dataSource.database.AppDatabase
import uz.demo.roomdb.data.dataSource.database.movielist.MovieDao
import uz.demo.roomdb.data.dataSource.database.movieDetail.MovieDetailDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao {
        return database.movieDao
    }

    @Singleton
    @Provides
    fun provideMovieDetailDao(database: AppDatabase): MovieDetailDao {
        return database.movieDetailDao
    }

    @Singleton
    @Provides
    fun provideDatabase(applicationContext: Application): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}
