package uz.demo.roomdb.ui.home

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
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
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_detail.*
import uz.demo.roomdb.R
//import uz.demo.movieApp.databinding.MovieDetailBinding
import uz.demo.roomdb.di.AppComponent
import uz.demo.roomdb.ui.home.viewmodel.MovieDetailViewModel
import uz.demo.roomdb.databinding.MovieDetailBinding
import uz.demo.roomdb.ui.home.adapters.ActorListAdapter
import uz.demo.roomdb.ui.home.viewmodel.MovieActorListViewModel
//import uz.demo.roomdb.databinding.MovieDetailBinding
import javax.inject.Inject
import kotlin.properties.Delegates

class MovieDetailFragment : Fragment(R.layout.movie_detail) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var viewModelActor: MovieActorListViewModel by Delegates.notNull()

    private var viewModel: MovieDetailViewModel by Delegates.notNull()

     private var binding: MovieDetailBinding by Delegates.notNull()

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
        binding = MovieDetailBinding.inflate(inflater)
        return binding.root
        //returning view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieDetailViewModel::class.java)

        initVm()
        viewModelActor = ViewModelProvider(this,viewModelFactory).get(MovieActorListViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_actorList)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
                false)
        }
        val adapter = ActorListAdapter(layoutInflater){id ->
            activity?.supportFragmentManager?.commit {
                replace<ActorDetailsFragment>(
                    containerViewId = R.id.fragment_container_view_tag,
                    args = bundleOf("id" to id)
                ).addToBackStack("replacement")
            }

        }
        recyclerView.adapter = adapter
        arguments?.getInt("id")?.let { viewModelActor.getActorList(it) }
        viewModelActor.actorListLivedata.observe(this){
            adapter.setItems(it)
        }

    }


    private fun initVm() {
        arguments?.getInt("id")?.let { viewModel.getMovieDetail(it) }

        viewModel.movieDetailLiveData.observe(this){
            binding.movieDetailTitle.text = it?.title
            binding.movieBudget.text = it?.budget.toString()
            binding.movieRate.text = it?.voteAverage.toString()
            binding.movieDescription.text = it?.overview
            binding.movieDescription.movementMethod = ScrollingMovementMethod()
            Glide.with(binding.root)
                .load(it?.movieImage)
                .into(binding.movieDetailImage)
        }

    }

}