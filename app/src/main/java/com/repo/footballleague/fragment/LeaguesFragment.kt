package com.repo.footballleague.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.repo.footballleague.FootballLeagueApplication

import com.repo.footballleague.R
import com.repo.footballleague.adapter.LeaguesDataAdapter
import com.repo.footballleague.viewModel.LeaguesViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_leagues.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class LeaguesFragment : Fragment() {
    @Inject
    lateinit var viewModel: LeaguesViewModel
    private val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val application = activity?.application as FootballLeagueApplication
        application.getComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leagues, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToGetLeaguesData()
    }

    private fun subscribeToGetLeaguesData() {
        compositeDisposable?.add(viewModel.leaguesData.subscribe(
            {
                rv_leagues_data.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                rv_leagues_data.adapter = LeaguesDataAdapter(context, it)
            },{
                Log.e("SERVICE CALL ERROR",it.message)
            }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.dispose()
    }

}
