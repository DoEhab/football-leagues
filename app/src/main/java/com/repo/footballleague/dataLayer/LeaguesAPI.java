package com.repo.footballleague.dataLayer;

import com.repo.footballleague.model.Competitions;
import com.repo.footballleague.model.LeaguesDataResponse;
import io.reactivex.Flowable;

import java.util.List;

/**
 * Created by Doha on 20/07/19.
 */
public interface LeaguesAPI {

    Flowable<List<Competitions>> getLeaguesData();

}
