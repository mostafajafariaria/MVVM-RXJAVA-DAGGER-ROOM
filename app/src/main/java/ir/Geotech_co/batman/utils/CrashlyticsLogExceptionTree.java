package ir.Geotech_co.batman.utils;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;


public class CrashlyticsLogExceptionTree extends Timber.Tree {
    private final int mLogPriority;

    /**
     * Create instance with default log priority of ERROR.
     */
    public CrashlyticsLogExceptionTree() {
        this(Log.ERROR);
    }

    /**
     * @param logPriority          Minimum log priority to send exception. Expects one of constants defined in {@link Log}.
     *
     */
    @SuppressWarnings("WeakerAccess")
    public CrashlyticsLogExceptionTree(int logPriority) {
        // Ensure crashlytics class is available, fail-fast if not available.
        // TODO: 12/18/17 add crash reporting method
//        Crashlytics.class.getCanonicalName();
        mLogPriority = logPriority;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected boolean isLoggable(int priority) {
        return priority >= mLogPriority;
    }

    @Override
    protected void log(int priority, String tag, @NotNull String message, Throwable t) {

        //noinspection StatementWithEmptyBody
        if (t != null) {
//            Crashlytics.logException(t);
        } else {
            String formattedMessage = LogMessageHelper.format(priority, tag, message);
            // TODO: 12/18/17 add crash reporting method
//            Crashlytics.logException(new StackTraceRecorder(formattedMessage));
        }
    }
}
