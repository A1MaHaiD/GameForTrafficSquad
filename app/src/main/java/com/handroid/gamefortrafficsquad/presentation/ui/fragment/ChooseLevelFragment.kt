package com.handroid.gamefortrafficsquad.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.handroid.gamefortrafficsquad.databinding.FragmentChooseLevelBinding
import com.handroid.gamefortrafficsquad.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chooseLevel()
    }

    private fun launchGameFragment(level: Level) {
       findNavController().navigate(
           ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level)
       )
    }

    private fun chooseLevel() {
        with(binding) {
            btnLevelTest.setOnClickListener {
                launchGameFragment(level = Level.TEST)
            }
            btnLevelEasy.setOnClickListener {
                launchGameFragment(level = Level.EASY)
            }
            btnLevelNormal.setOnClickListener {
                launchGameFragment(level = Level.NORMAL)
            }
            btnLevelHard.setOnClickListener {
                launchGameFragment(level = Level.HARD)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}