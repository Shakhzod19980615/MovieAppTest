package uz.demo.roomdb.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.demo.roomdb.R
import uz.demo.roomdb.di.AppComponent
import uz.demo.roomdb.ui.home.adapters.MovieAdapter
import uz.demo.roomdb.ui.home.viewmodel.MovieViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class   MoviesFragment : Fragment(R.layout.popular_movies) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModel: MovieViewModel by Delegates.notNull()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_home)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,
                false)
        }
        val adapter = MovieAdapter(layoutInflater) { id ->
            activity?.supportFragmentManager?.commit {
                replace<MovieDetailFragment>(
                    containerViewId = R.id.fragment_container_view_tag,
                    args = bundleOf("id" to id)
                ).addToBackStack("replacement")
            }

        }
        recyclerView.adapter = adapter
        viewModel.getMovie()
        viewModel.moviesLiveData.observe(this) {
            adapter.setItems(it)
        }

        val recyclerViewTop = view.findViewById<RecyclerView>(R.id.recyclerView_top)
        recyclerViewTop.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        val adapterTopRatedMovie = MovieAdapter(layoutInflater){ id ->
            activity?.supportFragmentManager?.commit {
                replace<MovieDetailFragment>(
                    containerViewId = R.id.fragment_container_view_tag,
                    args = bundleOf("id" to id)
                ).addToBackStack("replacement")
            }
        }
        recyclerViewTop.adapter = adapterTopRatedMovie
        viewModel.getTopRatedMovie()
        viewModel.topRatedLiveData.observe(this){
            adapterTopRatedMovie.setItems(it)
        }

        val recyclerViewUpcoming = view.findViewById<RecyclerView>(R.id.recyclerView_upcoming)
        recyclerViewUpcoming.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        val adapterUpcomingMovie = MovieAdapter(layoutInflater){ id ->
            activity?.supportFragmentManager?.commit {
                replace<MovieDetailFragment>(
                    containerViewId = R.id.fragment_container_view_tag,
                    args = bundleOf("id" to id)
                ).addToBackStack("replacement")
            }
        }
        recyclerViewUpcoming.adapter = adapterUpcomingMovie
        viewModel.getUpcomingMovie()
        viewModel.upcomingMovieLiveData.observe(this){
            adapterUpcomingMovie.setItems(it)
        }
    }

}