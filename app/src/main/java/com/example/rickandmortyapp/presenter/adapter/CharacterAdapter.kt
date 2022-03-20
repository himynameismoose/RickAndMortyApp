package com.example.rickandmortyapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapp.CharactersListQuery
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ItemCharacterBinding

class CharacterAdapter :
    ListAdapter<CharactersListQuery.Result, CharacterViewHolder>(CharacterDiffUtil()) {

    // clicked character card
    var onItemClicked: ((CharactersListQuery.Result) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: ItemCharacterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_character,
            parent,
            false
        )

        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.binding.character = getItem(position)

        // opens character details on a new screen
        val character = getItem(position)
        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(character)
        }
    }
}

class CharacterViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)

class CharacterDiffUtil : DiffUtil.ItemCallback<CharactersListQuery.Result>() {

    override fun areItemsTheSame(
        oldItem: CharactersListQuery.Result,
        newItem: CharactersListQuery.Result
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CharactersListQuery.Result,
        newItem: CharactersListQuery.Result
    ): Boolean {
        return oldItem == newItem
    }
}

// To be used to pull images for characters
@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    imageView.load(url) { crossfade(true) }
}