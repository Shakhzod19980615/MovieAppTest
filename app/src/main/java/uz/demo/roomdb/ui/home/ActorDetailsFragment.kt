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
import com.bumptech.glide.Glide
import uz.demo.roomdb.R
import uz.demo.roomdb.databinding.ActorDetailBinding
import uz.demo.roomdb.di.AppComponent
import uz.demo.roomdb.ui.home.adapters.MovieAdapter
import uz.demo.roomdb.ui.home.viewmodel.ActorDetailViewModel
import uz.demo.roomdb.ui.home.viewmodel.MovieViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class ActorDetailsFragment : Fragment(R.layout.movie_detail) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var viewModel: ActorDetailViewModel by Delegates.notNull()
    private var viewModelKnownMovie : MovieViewModel by Delegates.notNull()
    private var binding: ActorDetailBinding by Delegates.notNull()

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
        binding = ActorDetailBinding.inflate(inflater)
        return binding.root
        //returning view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ActorDetailViewModel::class.java)
        initVm()

        viewModelKnownMovie = ViewModelProvider(this,viewModelFactory)
            .get(MovieViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_actorMovies)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
                false)
        }
        val adapter = MovieAdapter(layoutInflater){ id ->
            activity?.supportFragmentManager?.commit {
                replace<MovieDetailFragment>(
                    containerViewId = R.id.fragment_container_view_tag,
                    args = bundleOf("id" to id)
                ).addToBackStack("replacement")
            }

        }
        recyclerView.adapter = adapter
        arguments?.getInt("id")?.let { viewModelKnownMovie.getKnownMovies(it) }
        viewModelKnownMovie.knownMoviesLiveData.observe(this){
            adapter.setItems(it)
        }
    }

    private fun initVm() {
        arguments?.getInt("id")?.let { viewModel.getActorDetail(it) }

        viewModel.actorDetailLiveData.observe(this){
            binding.actorName.text = it?.name
            binding.actorBirthDate.text = it?.birthday
            binding.actorBiography.text = it?.biography
            Glide.with(binding.root)
                .load(it?.profile_path)
                .into(binding.actorDetailImage)
        }
    }

}