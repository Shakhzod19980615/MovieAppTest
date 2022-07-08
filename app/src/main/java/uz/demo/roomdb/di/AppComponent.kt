package uz.demo.roomdb.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import uz.demo.roomdb.di.networkModule.NetworkModule
import uz.demo.roomdb.di.room.DatabaseModule
import uz.demo.roomdb.di.viewmodel.ViewModelModule
import uz.demo.roomdb.ui.home.*
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: MoviesFragment)
    fun inject(fragment: MovieDetailFragment)
    fun inject (fragment: ActorDetailsFragment)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    companion object {
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return requireNotNull(instance) { "AppComponent must be initialized" }
        }

        fun create(application: Application): AppComponent {
            instance = DaggerAppComponent.factory().create(application)
            return instance!!
        }
    }
}