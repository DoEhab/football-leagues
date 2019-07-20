package com.repo.footballleague.viewModel;

import com.repo.footballleague.model.Competitions;
import com.repo.footballleague.model.LeaguesDataResponse;
import io.reactivex.Flowable;

import java.util.List;

/**
 * Created by Doha on 20/07/19.
 */
public interface LeaguesViewModel {
    Flowable<LeaguesDataResponse> getLeaguesData();
}
