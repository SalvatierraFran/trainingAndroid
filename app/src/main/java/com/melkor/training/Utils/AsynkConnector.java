package com.melkor.training.Utils;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by franco.salvatierra on 08/02/2018.
 */

public class AsynkConnector extends AsyncTask<String, String, String> {
    private final String endpoint = "https://jsonplaceholder.typicode.com";

    private final String append = "/users";

    static final String COOKIES_HEADER = "Set-Cookie";

    public static final int USER = 0;

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PUT = "PUT";

    private Callback callback;
    private String content;
    private int service;
    private String param;

    private String url;
    private String method = GET;

    private int responseCode;

    public AsynkConnector(int service, String param, String content, Callback callback)
    {
        this.callback = callback;
        this.content = content;
        this.service = service;
        this.param = param;

        url = composeURL(service, param);
    }

    private String composeURL(int service, String param)
    {
        String ret = null;
        switch (service)
        {
            case USER:
                ret = endpoint+param+append;
                method = GET;
                break;
        }
        return ret;
    }

    public String doConnection()
    {
        String ret = null;

        try
        {
            URL obj = new URL(this.url);

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);

            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");

            byte[]body = this.content.getBytes("UTF-8");

            if(method.equalsIgnoreCase(POST) || method.equalsIgnoreCase(PUT))
            {
                OutputStream os = conn.getOutputStream();
                os.write(body);
                os.close();
            }

            responseCode = conn.getResponseCode();
            InputStream is;

            if(responseCode == 200){
                is = conn.getInputStream();
            }else{
                is = conn.getErrorStream();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = br.readLine()) != null)
            {
                sb.append(line);
            }

            br.close();
            is.close();
            conn.disconnect();

            ret = sb.toString();
        }
        catch (MalformedURLException e)
        {
            responseCode = -10;
            ret = e.getMessage();
        }
        catch(IOException e)
        {
            responseCode = -10;
            ret = e.getMessage();
        }
        catch(Exception e)
        {
            responseCode = -10;
            ret = e.getMessage();
        }

        return ret;
    }

    @Override
    protected String doInBackground(String... strings)
    {
        return doConnection();
    }

    @Override
    protected void onPostExecute(String result)
    {
        callback.completed(result, responseCode);
    }

    @Override
    protected void onPreExecute()
    {
        callback.starting();
    }

    @Override
    protected void onProgressUpdate(String... text)
    {
        callback.update();
    }


}
