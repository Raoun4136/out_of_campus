package com.oug.Main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oug.databinding.ItemChatBinding

class ChatRVAdapter(private val chatList: ArrayList<Chat>) : RecyclerView.Adapter<ChatRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount() = chatList.size

    inner class ViewHolder(val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(chat: Chat){
            binding.itemChatBackgroundIv.setImageResource(chat.imgRes!!)
            binding.itemChatTitleTv.text = chat.title
            binding.itemTopicMainTv.text = chat.mainTag
            binding.itemTopicSubTv.text = chat.subTag
        }
    }
}