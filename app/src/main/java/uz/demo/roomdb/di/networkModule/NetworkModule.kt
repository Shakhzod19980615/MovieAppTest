package uz.demo.roomdb.di.networkModule

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import uz.demo.roomdb.data.MovieRepositoryImpl
import uz.demo.roomdb.data.service.ApiService
import uz.demo.roomdb.domain.data.repository.MovieRepository
import uz.demo.roomdb.domain.interactor.movie.MovieInteractor
import uz.demo.roomdb.domain.interactor.movie.MovieInteractorImpl
import javax.inject.Singleton

@Module(includes = [NetworkModule.Providers::class])
interface NetworkModule {

    @Module
    object Providers {

        @OptIn(ExperimentalSerializationApi::class)
        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit {
            val json = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(provideOkhttp())
                .addConverterFactory(json.asConverterFactory(MediaType.parse("application/json")!!))
                .build()
        }

        @Singleton
        @Provides
        fun provideApi(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Singleton
        @Provides
        fun provideOkhttp(): OkHttpClient {
            val okHttpClient = OkHttpClient.Builder()
            return okHttpClient.build()

        }

        @Singleton
        @Provides
        fun provideRepository(
            movieRepositoryImpl: MovieRepositoryImpl
        ): MovieRepository {
            return movieRepositoryImpl
        }
    }


    @Binds
    fun provideMovieInteractor(impl: MovieInteractorImpl): MovieInteractor

}