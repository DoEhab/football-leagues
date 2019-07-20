package com.repo.footballleague.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.repo.footballleague.model.Competitions
import com.repo.footballleague.model.LeaguesDataResponse

/**
 * Created by Doha on 20/07/19.
 */

@Database(entities = [Competitions::class], version = 1, exportSchema = false)
abstract class LeaguesDatabase : RoomDatabase() {
    abstract fun leaguesDao(): LeaguesDao

}