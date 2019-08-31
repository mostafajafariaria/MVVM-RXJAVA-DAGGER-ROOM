package ir.Geotech_co.batman.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Utils {

    public static boolean isCatchEnabled() {
        return false;

    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } else {
            return true;
        }
    }


    public static String getTime(String str) {
        String time = null;
        if (!TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) >= 14) {
            time = str.replace(".", "");
            time = time.substring(8, 14);
            String h = time.substring(0, 2);
            String m = time.substring(2, 4);
            String s = time.substring(4, 6);
            time = h + ":" + m + ":" + s;
        }
        return time;


    }


    public static String getDate(String str) {
        String data = null;
        if (!TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) >= 14) {
            str = str.replace(".", "");
            data = str.substring(0, 8);
            String y = data.substring(0, 4);
            String m = data.substring(4, 6);
            String d = data.substring(6, 8);
            data = y + "/" + m + "/" + d;
        }
        return data;


    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int spToPx(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, Resources.getSystem().getDisplayMetrics());
    }

    public static void replaceFragment(@IdRes int fragmentId, Fragment newFragment, FragmentManager fragmentManager) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(fragmentId, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public static boolean validationNationalCode(String code) {
        return !TextUtils.isEmpty(code) && TextUtils.isDigitsOnly(code) && TextUtils.getTrimmedLength(code) == 10;
    }

    public static boolean validationMobileNumber(String mobile) {
        return !TextUtils.isEmpty(mobile) && TextUtils.isDigitsOnly(mobile) && mobile.startsWith("09")
                && (!(TextUtils.getTrimmedLength(mobile) < 11));
    }

    public static boolean validationName(String name) {
        return !TextUtils.isEmpty(name) && (!name.contains("0") || !name.contains("1") ||
                !name.contains("2") || !name.contains("3") || !name.contains("4") || !name.contains("5") ||
                !name.contains("6") || !name.contains("7") || !name.contains("8") || !name.contains("9")) &&
                (TextUtils.getTrimmedLength(name) > 2);

    }

    public static String getDayName(int day) {
        if (day == 0) return "شنبه";
        else if (day == 1) return "یکشنبه";
        else if (day == 2) return "دوشنبه";
        else if (day == 3) return "سه شنبه";
        else if (day == 4) return "چهارشنبه";
        else if (day == 5) return "پنج شنبه";
        else if (day == 6) return "جمعه";
        else return null;
    }

    public static void menuIconColor(MenuItem menuItem, int color) {
        Drawable drawable = menuItem.getIcon();
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static Bitmap getBitmap(Context context, Uri imageUri) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null) {
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getGoogleMapThumbnail(double lati, double longi) {
        String url = "http://maps.google.com/maps/api/staticmap?center=" + lati + "," + longi + "&zoom=15&size=200x200&sensor=false";
//        Bitmap bmp = null;
//        HttpClient httpclient = new DefaultHttpClient();
//        HttpGet request = new HttpGet(URL);
//
//        InputStream in = null;
//        try {
//            in = httpclient.execute(request).getEntity().getContent();
//            bmp = BitmapFactory.decodeStream(in);
//            in.close();
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        return url;
    }

    public static String getAndroidVersion() {
        return String.valueOf(android.os.Build.VERSION.SDK_INT);

    }

    public static double meterDistanceBetweenPoints(float lat_a, float lng_a, float lat_b, float lng_b) {
        float pk = (float) (180.f / Math.PI);

        float a1 = lat_a / pk;
        float a2 = lng_a / pk;
        float b1 = lat_b / pk;
        float b2 = lng_b / pk;

        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);
        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);
        double t3 = Math.sin(a1) * Math.sin(b1);
        double tt = Math.acos(t1 + t2 + t3);

        return 6366000 * tt;
    }

    public static JSONObject pojoToJson(Object o) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(o);

        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

}
