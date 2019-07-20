package com.repo.footballleague;

import com.repo.footballleague.fragment.LeaguesFragment;
import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(FootballLeagueApplication app);
    void inject(LeaguesFragment leaguesFragment);
}
