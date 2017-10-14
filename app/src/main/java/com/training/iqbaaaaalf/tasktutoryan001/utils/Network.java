package com.training.iqbaaaaalf.tasktutoryan001.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Scanner;

/**
 * Created by iqbaaaaalf on 10/6/2017.
 */

public class Network {

    final static String Base_Url =
            "http://yippytech.com:3000/search";

    final static String Param_Query =
            "key";

    public static URL buildURL(String query) {
        Uri builtUri = Uri.parse(Base_Url).buildUpon()
                .appendQueryParameter(Param_Query, query)
                .build();

        URL url = null;

        String urlString = null;
        try {
            urlString = URLDecoder.decode(builtUri.toString(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
