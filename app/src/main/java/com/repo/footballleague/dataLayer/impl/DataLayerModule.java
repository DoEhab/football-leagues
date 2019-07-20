package com.repo.footballleague.dataLayer.impl;

import com.repo.footballleague.dataLayer.LeaguesAPI;
import com.repo.footballleague.service.LeaguesService;
import com.repo.footballleague.util.RetrofitFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Doha on 20/07/19.
 */
@Module
public class DataLayerModule {
    @Singleton
    @Provides
    LeaguesService providesHomeService() {
        return RetrofitFactory.createService(LeaguesService.class);
    }

    @Singleton
    @Provides
    LeaguesAPI providesHomeAPI(LeaguesService service) {
        return new LeaguesAPIImpl(service);
    }

}
