package com.suiunbek.foodtrackerpractice.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suiunbek.foodtrackerpractice.databinding.FragmentOnBoardMainBinding

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeViewPage()

    }

    private fun changeViewPage() {
      when(requireArguments()) {

      }
    }


}