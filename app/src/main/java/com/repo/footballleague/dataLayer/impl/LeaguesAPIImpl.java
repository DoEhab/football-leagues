package com.repo.footballleague.dataLayer.impl;

import com.repo.footballleague.dataLayer.LeaguesAPI;
import com.repo.footballleague.database.LeaguesDao;
import com.repo.footballleague.model.Competitions;
import com.repo.footballleague.model.LeaguesDataResponse;
import com.repo.footballleague.service.LeaguesService;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import org.intellij.lang.annotations.Flow;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doha on 20/07/19.
 */
public class LeaguesAPIImpl implements LeaguesAPI {

    private final LeaguesDao leaguesDao;
    private final LeaguesService service;
    private List<Competitions> networkResponseList = new ArrayList<>();

    LeaguesAPIImpl(LeaguesService service, LeaguesDao leaguesDao) {
        this.service = service;
        this.leaguesDao = leaguesDao;
    }

    private Flowable<List<Competitions>> getNetworkData() {
        return service.getRepoData().map(new Function<LeaguesDataResponse, List<Competitions>>() {
            @Override
            public List<Competitions> apply(LeaguesDataResponse leaguesDataResponse) throws Exception {
                leaguesDao.insertAll(leaguesDataResponse.getCompetitions());
                for (int i = 0; i < leaguesDataResponse.getCompetitions().size(); i++) {
                    networkResponseList.add(leaguesDataResponse.getCompetitions().get(i));
                }
                return networkResponseList;
            }
        });
    }

 /*   @Override
    public Flowable<List<Competitions>> getLeaguesData() {
        return getNetworkData().publish
                (new Function<Flowable<List<Competitions>>, Publisher<List<Competitions>>>() {
                    @Override
                    public Publisher<List<Competitions>> apply(Flowable<List<Competitions>> networkResponse) throws Exception {
                        return Flowable.merge(networkResponse,
                                leaguesDao.getAll().takeUntil(networkResponse));
                    }
                });

    }*/
 @Override
 public Flowable<List<Competitions>> getLeaguesData() {
     Flowable<List<Competitions>> temp=getNetworkData();
     return Flowable.concat(temp,leaguesDao.getAll());

 }
}
