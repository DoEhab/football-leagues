package com.repo.footballleague.viewModel.impl;

import com.repo.footballleague.dataLayer.LeaguesAPI;
import com.repo.footballleague.viewModel.LeaguesViewModel;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Doha on 20/07/19.
 */
@Module
public class ViewModelModule {

    @Provides
    @Singleton
    LeaguesViewModel provideLeaguesViewModel(LeaguesAPI api) {
        return new LeaguesViewModelImpl(api);
    }
}
