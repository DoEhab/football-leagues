package com.repo.footballleague.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Doha on 20/07/19.
 */

data class LeaguesDataResponse(
 var competitions: List<Competitions>
)


data class Competitions(
    var id: Int,
    @SerializedName("name")
    var leagueName: String,
    var currentSeason: CurrentSeason
)

data class CurrentSeason(
    var startDate: String,
    var endDate: String
)
