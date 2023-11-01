package com.hendro.androidkotlinbindingbasicui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendro.androidkotlinbindingbasicui.databinding.RevItemsBinding

class RecycleViewAdapter (private var temanList: List<Teman>) :
        RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>(){

        //binding layout: 1. ganti "binding: ItemRowLayoutBinding" dan "binding.root"
        class MyViewHolder(val binding: RevItemsBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): RecycleViewAdapter.MyViewHolder {
                //binding layout: 2. tarik layout
                val binding = RevItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MyViewHolder(binding)
        }

        override fun onBindViewHolder(holder: RecycleViewAdapter.MyViewHolder, position: Int) {
                //binding layout: 3. letakkan nilai pada layout

                holder.binding.tvNama.text = temanList[position].getNama()

                Glide.with(holder.itemView.context)
                        .load(temanList[position].getGambar())
                        .into(holder.binding.imageview)

                holder.itemView.setOnClickListener{
                        //todo: respon klik
                }
        }

        override fun getItemCount(): Int {
                return temanList.size
        }

}