package uz.demo.roomdb.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.demo.roomdb.databinding.ItemMovieCardBinding
import uz.demo.roomdb.domain.model.MovieActorModel

class ActorListAdapter(
    private val layoutInflater: LayoutInflater,
    private val onItemClick: (Id : Int) -> Unit
) : RecyclerView.Adapter<ActorListAdapter.ViewHolder>() {
    private val actorList : MutableList<MovieActorModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorListAdapter.ViewHolder {
        val binding = ItemMovieCardBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorListAdapter.ViewHolder, position: Int) {
        holder.bindData(actorListModel = actorList[position])
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    fun setItems(actorList: List<MovieActorModel>) {
        this.actorList.clear()
        this.actorList.addAll(actorList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemMovieCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(actorListModel: MovieActorModel) {
            binding.movieTitle.text = actorListModel.name
            itemView.setOnClickListener {
                onItemClick(actorListModel.id)

            }
            Glide
                .with(binding.root)
                .load(actorListModel.profile_path)
                .into(binding.movieImage)

        }
    }

}