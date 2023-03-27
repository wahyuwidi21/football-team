package com.made.footballteam.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.decode.SvgDecoder
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.made.footballteam.core.domain.model.FootballTeam
import com.made.footballteam.databinding.ItemTeamBinding

@Suppress("unused")
class FavoriteAdapter :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private var items: List<FootballTeam>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items?.get(position))
    }

    fun setItem(items: List<FootballTeam>?) {
        this.items = items
        notifyItemInserted(0)
    }

    @Suppress("unused")
    class ViewHolder(private val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: FootballTeam?) {
            binding.txtTeam.text = data?.name

            if (data?.crest?.takeLast(3) != "svg") Glide.with(itemView.context)
                .load(data?.crest)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerInside()
                .into(binding.imgTeamLogo)
            else binding.imgTeamLogo.load(data.crest) {
                decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
            }
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0


}