package com.repo.footballleague.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Doha on 20/07/19.
 */

data class LeaguesDataResponse(
    var competitions: List<Competitions>
)
@Entity
data class Competitions(
    @PrimaryKey(autoGenerate = true)
    var tableId: Int = 0,
    var id: Int,
    @SerializedName("name")
    var leagueName: String,
    @Embedded
    var currentSeason: CurrentSeason?
)

data class CurrentSeason(
    var startDate: String?,
    var endDate: String
)
