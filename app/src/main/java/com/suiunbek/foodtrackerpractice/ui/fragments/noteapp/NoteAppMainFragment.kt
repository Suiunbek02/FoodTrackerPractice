package com.suiunbek.foodtrackerpractice.ui.fragments.noteapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.suiunbek.foodtrackerpractice.App
import com.suiunbek.foodtrackerpractice.R
import com.suiunbek.foodtrackerpractice.databinding.FragmentNoteAppMainBinding
import com.suiunbek.foodtrackerpractice.models.NoteModel
import com.suiunbek.foodtrackerpractice.ui.adapters.NoteAdapter

class NoteAppMainFragment : Fragment(), NoteAdapter.OnNoteClickListener {

    private lateinit var binding: FragmentNoteAppMainBinding

    private val adapter: NoteAdapter = NoteAdapter(this, this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.preferenceHelper.putValue("isLiner", true)
        binding = FragmentNoteAppMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecViewAdapter()
        setNoteAndAddToList()
        addNote()
        getNoteAndAddToLIst()

    }


    private fun initializeRecViewAdapter() = with(binding) {
        val isShapeRecViewLinear = App.preferenceHelper.isLinearLayout("isLinear")

        if (isShapeRecViewLinear) {
            recycleView.layoutManager = LinearLayoutManager(requireContext())
        } else {
            recycleView.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        recycleView.adapter = adapter
    }

    private fun setNoteAndAddToList() = with(binding) {
        shapeRecycleView.setOnClickListener {
            val isShapeRecViewLinear = App.preferenceHelper.isLinearLayout("isLinear")

            if (isShapeRecViewLinear) {
                recycleView.layoutManager = GridLayoutManager(requireContext(), 2)
                App.preferenceHelper.removeValue("isLinear")
                App.preferenceHelper.putValue("isLinear", false)
                shapeRecycleView.setBackgroundColor(R.drawable.ic_liniar_layout_shape)
                Toast.makeText(requireContext(), "Grid - $isShapeRecViewLinear", Toast.LENGTH_LONG)
                    .show()
            } else {
                recycleView.layoutManager = LinearLayoutManager(requireContext())
                App.preferenceHelper.removeValue("isLinear")
                App.preferenceHelper.putValue("isLinear", true)
                shapeRecycleView.setBackgroundColor(R.drawable.ic_liniar_layout_shape)
                Toast.makeText(
                    requireContext(),
                    "Linear - $isShapeRecViewLinear",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun addNote() = with(binding) {
        addNewNote.setOnClickListener {
            findNavController().navigate(
                R.id.action_noteAppMainFragment_to_noteAppDetailFragment
            )
        }
    }

    private fun getNoteAndAddToLIst() {
        App.getDataIntense()?.getNoteDao()?.getAllModels()?.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

    override fun onLongClick(model: NoteModel) {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle("хотите удалить заметку")
            .setMessage("Вы действительно хотите удалить заметку,")
            .setPositiveButton("Да", DialogInterface.OnClickListener { dialogInterface, i ->
                App.getDataIntense()?.getNoteDao()?.delete(model)
            })
            .setNegativeButton("нет", DialogInterface.OnClickListener { dialogInterface, i ->

            }).create().show()
    }

    override fun onShortClick(model: NoteModel) {
        App.preferenceHelper.putValue("changeNote", true)
        findNavController().navigate(
            R.id.noteAppMainFragment
        )
    }
}