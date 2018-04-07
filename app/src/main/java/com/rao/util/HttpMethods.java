package com.rao.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * Created by Administrator on 2018/4/7.
 */

public class HttpMethods {
    public static HttpURLConnection postMethod(String requestUrl,String data) throws IOException {

        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setReadTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
        conn.setDoOutput(true);
        conn.getOutputStream().write(data.getBytes());
        return conn;

    }






}
