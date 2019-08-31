package ir.Geotech_co.batman.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Toast;

import dagger.android.support.DaggerAppCompatActivity;


@SuppressLint("Registered")
public abstract class BaseDaggerCompatActivity extends DaggerAppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int string) {
        Toast.makeText(this, getString(string), Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
