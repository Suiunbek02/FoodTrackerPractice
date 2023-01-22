package com.suiunbek.foodtrackerpractice.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suiunbek.foodtrackerpractice.R
import com.suiunbek.foodtrackerpractice.databinding.ItemNoteBinding
import com.suiunbek.foodtrackerpractice.models.NoteModel

class NoteAdapter(
    private val noteOnClickListener: OnNoteClickListener,
    private val noteOnShortClickListener: OnNoteClickListener
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var noteList: List<NoteModel> = ArrayList()

    fun setList(list: List<NoteModel>) {
        this.noteList = list
        notifyDataSetChanged()
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemNoteBinding.bind(item)
        fun onBind(model: NoteModel, listener: OnNoteClickListener) {
            binding.itemTitle.text = model.title
            binding.itemData.text = model.date
            binding.itemTime.text = model.time
            binding.itemDescription.text = model.description
            binding.itemCardView.setCardBackgroundColor(Color.parseColor(model.backgroundColor))

            itemView.setOnLongClickListener {
                listener.onLongClick(model)
                return@setOnLongClickListener true
            }

            itemView.setOnClickListener {
                listener.onShortClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(noteList[position], noteOnClickListener)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    interface OnNoteClickListener {
        fun onLongClick(model: NoteModel)
        fun onShortClick(model: NoteModel)


    }
}