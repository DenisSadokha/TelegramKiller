package com.example.telegramkiller.data;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthRequestHelper {
    public static final MediaType JSON
            = MediaType.parse("application/json");

    Callback callback;
    public  void attach(Callback callback){
        this.callback=callback;
    }
    public  void makeRequest(String req, String method, String body, String link){
        System.out.println(body);

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder().readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS);
        MediaType mediaType = MediaType.parse("charset=utf-8");
        final Request request;
 if(req.equals("in")){
     request = new Request.Builder()
             .url(link)
             .put(RequestBody.create(JSON, body))
             .build();
 } else {
      request = new Request.Builder()
             .url(link)
             .post(RequestBody.create(JSON, body))
             .build();
 }

        System.out.println(request);
   okHttpClient.newCall(request).enqueue(new Callback() {
       @Override
       public void onFailure(Call call, IOException e) {
           callback.onFailure(call, e);

       }

       @Override
       public void onResponse(Call call, Response response) throws IOException {

           callback.onResponse(call, response);

       }
   });



    }
}
