package com.repo.footballleague.dataLayer.impl;

import android.arch.persistence.room.Room;
import android.content.Context;
import com.repo.footballleague.dataLayer.LeaguesAPI;
import com.repo.footballleague.database.LeaguesDao;
import com.repo.footballleague.database.LeaguesDatabase;
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
    LeaguesAPI providesLeagueAPI(LeaguesService service,LeaguesDao leaguesDao) {
        return new LeaguesAPIImpl(service,leaguesDao);
    }

    @Singleton
    @Provides
    LeaguesDatabase providesLeaguesDatabase(Context context) {
        return Room.databaseBuilder(context,
                LeaguesDatabase.class, "db_name")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Singleton
    @Provides
    LeaguesDao providesLeaguesDao(LeaguesDatabase leaguesDatabase)
    {
        return leaguesDatabase.leaguesDao();
    }

}
