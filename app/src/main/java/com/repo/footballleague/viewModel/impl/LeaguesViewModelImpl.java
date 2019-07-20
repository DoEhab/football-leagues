package com.repo.footballleague.viewModel.impl;

import com.repo.footballleague.dataLayer.LeaguesAPI;
import com.repo.footballleague.model.Competitions;
import com.repo.footballleague.model.LeaguesDataResponse;
import com.repo.footballleague.viewModel.LeaguesViewModel;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

/**
 * Created by Doha on 20/07/19.
 */
public class LeaguesViewModelImpl implements LeaguesViewModel {
    private final LeaguesAPI leaguesAPI;

    LeaguesViewModelImpl(LeaguesAPI api) {
        this.leaguesAPI = api;
    }

    @Override
    public Flowable<List<Competitions>> getLeaguesData() {
        return leaguesAPI.getLeaguesData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
