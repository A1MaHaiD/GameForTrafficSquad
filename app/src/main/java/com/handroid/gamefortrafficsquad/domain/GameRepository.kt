package com.handroid.gamefortrafficsquad.domain

import com.handroid.gamefortrafficsquad.domain.entity.GameSettings
import com.handroid.gamefortrafficsquad.domain.entity.Level
import com.handroid.gamefortrafficsquad.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue:Int,
        countOfOptions:Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}