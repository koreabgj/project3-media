package com.example.teamproject_11.presentation.myvideo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.teamproject_11.databinding.ItemMyVideoBinding
import com.example.teamproject_11.presentation.home.model.HomeVideoModel

interface OnItemClick {
    fun onItemClick(item: HomeVideoModel)
    fun onItemClickToDelete(item: HomeVideoModel)
}

class MyVideoAdapter(private val data: List<HomeVideoModel>, private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class MyVideoViewHolder(private val binding: ItemMyVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeVideoModel) {
            binding.imageView.load(item.imgThumbnail) {
                crossfade(true)
            }
            binding.imageView.clipToOutline = true
            binding.tvVideoDate.text = showDate(item.dateTime!!)
            binding.myVideoContainer.setBackgroundColor(Color.TRANSPARENT)

            binding.tvVideoName.text = item.title
            binding.myVideoContainer.setOnClickListener {
                if (fragmentMode == 0) {
                    onItemClick.onItemClick(item)
                } else {
                    //삭제 아이템 누를때 마다 배경색 변경
                    onItemClick.onItemClickToDelete(item)
                    val color = (binding.myVideoContainer.background as ColorDrawable).color
                    if (color == Color.BLUE) {
                        binding.myVideoContainer.setBackgroundColor(Color.TRANSPARENT)
                    } else {
                        binding.myVideoContainer.setBackgroundColor(Color.BLUE)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMyVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyVideoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MyVideoViewHolder
        holder.bind(data[position])
    }
}

private fun showDate(date: String): String {
    val str = date.substring(0, 10)
    return str
}