package com.repo.footballleague

import android.app.Application
import android.support.v7.app.AppCompatDelegate

/**
 * Created by Doha on 19/07/19.
 */
class FootballLeagueApplication  : Application() {

    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }

    fun getComponent(): AppComponent = component
}