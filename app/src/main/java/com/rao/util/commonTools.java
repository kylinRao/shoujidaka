package com.rao.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.rao.shoujidaka.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;



public class commonTools {
    public static String rentServerApiUrl;

    public static void initApk(Context context) {
        rentServerApiUrl = context.getString(R.string.rent_server_uri);

        try {
            Log.d("initApk", String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
            Log.d("initApk", (String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))+"/rent.properties"));
            Properties props = new Properties();
            InputStream in;

            in = new FileInputStream(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))+"/rent.properties");
            props.load(in);

            rentServerApiUrl = props.getProperty("rentServerApiUrl");
            System.out.println(rentServerApiUrl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

    }


}

    public static HashMap<String, Object> getItems(Context context, String packageName) {

        PackageManager pckMan = context.getPackageManager();
        HashMap<String, Object> item = new HashMap<String, Object>();

        List<PackageInfo> packageInfo = pckMan.getInstalledPackages(0);

        for (PackageInfo pInfo : packageInfo) {
            if (pInfo.packageName.equals(packageName)) {


                item.put("appimage", pInfo.applicationInfo.loadIcon(pckMan));
                item.put("packageName", pInfo.packageName);
                item.put("versionCode", pInfo.versionCode);
                item.put("versionName", pInfo.versionName);
                item.put("appName", pInfo.applicationInfo.loadLabel(pckMan).toString());


            }
        }

        return item;
    }
}
