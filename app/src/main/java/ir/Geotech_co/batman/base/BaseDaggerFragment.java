package ir.Geotech_co.batman.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

import dagger.android.support.DaggerFragment;

public class BaseDaggerFragment extends DaggerFragment {

    public void showToast(String message) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void showToast(@StringRes int string) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context.getApplicationContext(), getString(string), Toast.LENGTH_SHORT).show();
        }
    }
}
