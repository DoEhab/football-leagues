package com.repo.footballleague.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.repo.footballleague.R
import com.repo.footballleague.fragment.LeaguesFragment

class LeaguesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leagues)
        launchFragment(LeaguesFragment(),true)
    }
    //TODO: replace with Nav controller
    private fun launchFragment(fragment: Fragment, addToBackStack: Boolean) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction = transaction.replace(R.id.sub_content, fragment)

        if (addToBackStack) {
            transaction = transaction.addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
    }
}
