package com.handroid.gamefortrafficsquad.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.handroid.gamefortrafficsquad.R
import com.handroid.gamefortrafficsquad.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {
    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        getGameResult()
    }

    private fun setClickListeners() {
        binding.btnTryAgain.setOnClickListener {
            tryAgainGame()
        }
    }

    private fun getGameResult() {
        binding.ivEmojiResult.setImageResource(getSmileResId())
        binding.tvRequiredAnswers.text = String.format(
            getString(R.string.necessary_right_answer),
            args.gameResult.gameSettings.minCount
        )
        binding.tvScoreAnswers.text = String.format(
            getString(R.string.your_score),
            args.gameResult.countOfRightAnswers
        )
        binding.tvRequiredPercentage.text = String.format(
            getString(R.string.necessary_percent_right_answer),
            args.gameResult.gameSettings.minPercent
        )
        binding.tvScorePercentage.text = String.format(
            getString(R.string.percentage_right_answers),
            getPercentOfRightAnswers()
        )
    }

    private fun getPercentOfRightAnswers() = with (args.gameResult) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }

    private fun getSmileResId(): Int {
        return if (args.gameResult.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun tryAgainGame() {
        findNavController().popBackStack()
    }
}