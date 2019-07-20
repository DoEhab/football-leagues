package com.repo.footballleague.dataLayer.impl;

import com.repo.footballleague.dataLayer.LeaguesAPI;
import com.repo.footballleague.model.Competitions;
import com.repo.footballleague.model.LeaguesDataResponse;
import com.repo.footballleague.service.LeaguesService;
import io.reactivex.Flowable;

import java.util.List;

/**
 * Created by Doha on 20/07/19.
 */
public class LeaguesAPIImpl implements LeaguesAPI {

    private final LeaguesService service;

    LeaguesAPIImpl(LeaguesService service){
        this.service = service;
    }

    @Override
    public Flowable<LeaguesDataResponse> getLeaguesData() {
        return service.getRepoData();
    }
}
