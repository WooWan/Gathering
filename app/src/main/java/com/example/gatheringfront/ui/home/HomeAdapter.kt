package com.example.gatheringfront.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gatheringfront.databinding.RecentContentViewBinding
import com.example.gatheringfront.dto.ContentDto
import com.google.firebase.firestore.FirebaseFirestore

class HomeAdapter(): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val contentDtoList = mutableListOf<ContentDto>()
    private var firestore: FirebaseFirestore? = null
    init{
        firestore = FirebaseFirestore.getInstance()
        firestore?.collection("info")
            ?.addSnapshotListener{ snapshot, error ->
                contentDtoList.clear()
                if (snapshot == null) {
                    return@addSnapshotListener
                }
                for (document in snapshot?.documents!!) {
                    contentDtoList.add(document.toObject(ContentDto::class.java)!!)
                }
                notifyDataSetChanged()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecentContentViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contentDtoList[position])
    }

    override fun getItemCount(): Int {
        return contentDtoList.size
    }
    class ViewHolder(val binding: RecentContentViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(content: ContentDto){
            binding.mView.text = content.title
        }
    }
}