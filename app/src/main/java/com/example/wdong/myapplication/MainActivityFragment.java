package com.example.wdong.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button btn;

    public MainActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_main, container, false);
        btn = (Button)root.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "clicked me", Toast.LENGTH_SHORT).show();
                new Thread() {
                    @Override
                    public void run() {

                        //HttpClient
                        HttpClient client = new DefaultHttpClient();
                        client.getParams().setParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET, "utf-8");
                        client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
                        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 6000);
                        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 6000);
                        client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "OS:android");
                        HttpGet get = new HttpGet("http://www.baidu.com");
                        List<NameValuePair> list = new ArrayList<NameValuePair>();
                        BasicNameValuePair search = new BasicNameValuePair("qqq", "fdkj");
                        BasicNameValuePair test = new BasicNameValuePair("test", "true");
                        list.add(search);
                        list.add(test);
                        try {
                            URI uri = URIUtils.createURI("http", "www.baidu.com", -1, "/search", URLEncodedUtils.format(list, "UTF-8"), null);
                            get = new HttpGet(uri);
                            HttpResponse response = client.execute(get);
                            Log.e("11111111", "Status code is " + response.getStatusLine().getStatusCode());
                            HttpEntity entity = response.getEntity();
                            if (entity != null) {
                                Log.e("11111111", EntityUtils.toString(entity));
                                //Log.e("WDONG", entity.getContent().toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            client.getConnectionManager().shutdown();
                        }


                        //HttpURLConnection example
                        try {
                            URL url = new URL("http://www.baidu.com");
                            Byte[] buffer;
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setDoOutput(true);
                            conn.setDoInput(true);
                            conn.connect();
                            OutputStream outStrm = conn.getOutputStream();
                            Log.e("WDONG", outStrm.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //JSON
                        try {
                            JSONObject jsonObject = new JSONObject();
                            JSONObject json = new JSONObject();
                            json.put("fdkj", "1111111");
                            json.put("jflkdj", 1484);
                            jsonObject.put("text", "1234");
                            jsonObject.put("value", true);
                            jsonObject.put("number", 100);
                            jsonObject.put("object", new DefaultHttpClient());
                            jsonObject.put("json", json);

                            Log.e("111111111", "JSONObject is " + jsonObject.toString());
                            Log.e("111111111", "JSON length is " + jsonObject.length());
                            Log.e("111111111", "son json " + jsonObject.getJSONObject("json").toString());
                            List<String> list1 = new ArrayList<String>();
                            list1.add("111111111");
                            list1.add("222222222");
                            list1.add("333333333");
                            list1.add("444444444");
                            JSONArray array = new JSONArray(list1);
                            JSONObject jsonObject1 = new JSONObject(jsonObject.toString());
                            Log.e("111111111", "jsonObject1 is " + jsonObject1.toString());
                            Log.e("111111111", "JSONArray is " + array.toString());
                            String sss = "";
                            JSONObject js = (JSONObject)new JSONTokener(jsonObject.toString()).nextValue();
                            Log.e("11111111", "js content is " + js.toString());
                            Iterator<String> iterator = js.keys();
                            while(iterator.hasNext()) {
                                String name = iterator.next();
                                Log.e("1111111111", "key is " + name + " value is " + js.get(name));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        //



                    }
                }.start();
            }
        });
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.menu1, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_me:
//                Toast.makeText(getActivity(), "menu setting", Toast.LENGTH_SHORT).show();
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }
}
