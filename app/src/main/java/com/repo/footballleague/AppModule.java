package com.repo.footballleague;

import android.app.Application;
import android.content.Context;

import com.repo.footballleague.dataLayer.impl.DataLayerModule;
import com.repo.footballleague.viewModel.impl.ViewModelModule;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;


@Module(includes = {DataLayerModule.class, ViewModelModule.class})
public class AppModule {
    private Application app;

    AppModule(Application app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context providesContext() {
        return app;
    }
}