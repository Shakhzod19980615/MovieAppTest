package uz.demo.roomdb.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.demo.roomdb.domain.model.MovieModel
import uz.demo.roomdb.databinding.ItemMovieCardBinding

class MovieAdapter(
    private val layoutInflater: LayoutInflater,
    val onItemClick: (Id : Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private val popularMovieList: MutableList<MovieModel> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ItemMovieCardBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bindData(popularMovieModel = popularMovieList[position])
    }

    override fun getItemCount(): Int {
        return popularMovieList.size

    }

    fun setItems(movieList: List<MovieModel>) {
        this.popularMovieList.clear()
        this.popularMovieList.addAll(movieList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemMovieCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bindData(popularMovieModel: MovieModel) {
            binding.movieTitle.text = popularMovieModel.title
           // binding.movieDescription.text = popularMovieModel.description
            Glide.with(binding.root).load(popularMovieModel.image).into(binding.movieImage)


        }

        init {
            itemView.setOnClickListener {
            val item = popularMovieList[bindingAdapterPosition]
                onItemClick(item.id)

            }
        }
    }

}