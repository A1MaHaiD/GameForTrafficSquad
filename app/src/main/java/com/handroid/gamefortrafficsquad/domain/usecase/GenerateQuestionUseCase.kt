package com.handroid.gamefortrafficsquad.domain.usecase

import com.handroid.gamefortrafficsquad.domain.GameRepository
import com.handroid.gamefortrafficsquad.domain.entity.Question

class GenerateQuestionUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question {
        return gameRepository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    companion object {
        const val COUNT_OF_OPTIONS = 6
    }
}