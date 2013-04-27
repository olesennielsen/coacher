package com.olesennielsen.coacher;

import android.accounts.AccountManager;
import android.content.Context;

import com.olesennielsen.coacher.authenticator.BootstrapAuthenticatorActivity;
import com.olesennielsen.coacher.authenticator.LogoutService;
import com.olesennielsen.coacher.core.CheckIn;
import com.olesennielsen.coacher.core.TimerService;
import com.olesennielsen.coacher.ui.BootstrapTimerActivity;
import com.olesennielsen.coacher.ui.CarouselActivity;
import com.olesennielsen.coacher.ui.CheckInsListFragment;
import com.olesennielsen.coacher.ui.ItemListFragment;
import com.olesennielsen.coacher.ui.NewsActivity;
import com.olesennielsen.coacher.ui.NewsListFragment;
import com.olesennielsen.coacher.ui.UserActivity;
import com.olesennielsen.coacher.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        entryPoints = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
