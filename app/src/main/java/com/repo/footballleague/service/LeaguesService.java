package com.repo.footballleague.service;

import com.repo.footballleague.model.Competitions;
import com.repo.footballleague.model.LeaguesDataResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by Doha on 20/07/19.
 */
public interface LeaguesService {
    @Headers("Content-Type: application/json")
    @GET("competitions")
    Flowable<LeaguesDataResponse> getRepoData();

}
