package com.repo.footballleague.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.repo.footballleague.R
import com.repo.footballleague.model.LeaguesDataResponse
import kotlinx.android.synthetic.main.league_data_item.view.*

/**
 * Created by Doha on 20/07/19.
 */
class LeaguesDataAdapter(
    val context: Context?,
    private val leaguesData: LeaguesDataResponse
) :
    RecyclerView.Adapter<LeaguesDataAdapter.ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.league_data_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

        holder.items.txt_league_id.text =
            context?.getString(R.string.league_id).plus(leaguesData.competitions[position].id)

        holder.items.txt_league_name.text =
            context?.getString(R.string.league_name).plus(leaguesData.competitions[position].leagueName)
        if (leaguesData.competitions[position].currentSeason == null) {
            holder.items.txt_start_date.visibility = View.GONE
            holder.items.txt_end_date.visibility = View.GONE
        } else {
            holder.items.txt_start_date.text =
                context?.getString(R.string.start_date).plus(leaguesData.competitions[position].currentSeason?.startDate)

            holder.items.txt_end_date.text =
                context?.getString(R.string.end_date).plus(leaguesData.competitions[position].currentSeason?.endDate)
        }

    }

    override fun getItemCount(): Int {
        return leaguesData.competitions.size
    }

    class ItemsViewHolder(val items: View) : RecyclerView.ViewHolder(items) {

    }
}

