package ir.Geotech_co.batman.utils;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Provides various threading schedulers.
 */

@SuppressWarnings("ALL")
public class SchedulersFacade {

    @Inject
    public SchedulersFacade() {
    }

    /**
     * IO thread pool scheduler
     */
    public Scheduler io() {
        return Schedulers.io();
    }

    /**
     * Computation thread pool scheduler
     */
    public Scheduler computation() {
        return Schedulers.computation();
    }

    public Scheduler single(){
        return Schedulers.single();
    }

    /**
     * Main Thread scheduler
     */
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}