package com.handroid.gamefortrafficsquad.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val maxSumValue: Int,
    var minCount: Int,
    var minPercent: Int,
    val gameTimeInSeconds: Int
) : Parcelable
