package com.handroid.gamefortrafficsquad.domain.usecase

import com.handroid.gamefortrafficsquad.domain.GameRepository
import com.handroid.gamefortrafficsquad.domain.entity.GameSettings
import com.handroid.gamefortrafficsquad.domain.entity.Level

class GetGameSettingsUseCase(
    private val gameRepository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return gameRepository.getGameSettings(level)
    }
}