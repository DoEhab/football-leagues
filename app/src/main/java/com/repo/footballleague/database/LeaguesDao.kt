package com.repo.footballleague.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.repo.footballleague.model.Competitions
import com.repo.footballleague.model.LeaguesDataResponse
import io.reactivex.Flowable

/**
 * Created by Doha on 20/07/19.
 */
@Dao
interface LeaguesDao {
    @Query("SELECT * FROM Competitions")
    fun getAll(): Flowable<List<Competitions>>

    @Insert
    fun insertAll(leaguesData: List<Competitions>)

}