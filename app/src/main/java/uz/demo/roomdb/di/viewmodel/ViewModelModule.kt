package uz.demo.roomdb.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.demo.roomdb.ui.home.viewmodel.ActorDetailViewModel
import uz.demo.roomdb.ui.home.viewmodel.MovieActorListViewModel
import uz.demo.roomdb.ui.home.viewmodel.MovieDetailViewModel
import uz.demo.roomdb.ui.home.viewmodel.MovieViewModel

@Module

interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    fun mainActivityViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    fun movieDetailViewModel(viewModel: MovieDetailViewModel) : ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(ActorDetailViewModel::class)
    fun actorDetailViewModel(viewModel: ActorDetailViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieActorListViewModel::class)
    fun movieActorListViewModel(viewModel: MovieActorListViewModel) : ViewModel
}