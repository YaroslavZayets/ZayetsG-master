package fcdk.zayetsgram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import fcdk.zayetsgram.data.AccessToken;
import fcdk.zayetsgram.data.User;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends Activity {
    WebView webView;
    private String code;
    private String token;

    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.instagram.com")
            .build();

    private RetroPost retroPost = retrofit.create(RetroPost.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webview);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);




        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Uri uri = Uri.parse(url);
                code = uri.getQueryParameter("code");


                if (code!=null){
                    getData(code);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        webView.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=e6b21190d0f940a789dd78ef3eb3e2ac&redirect_uri=http://yourcallback.com&response_type=code");
    }


    private void getData (String code){


        retroPost.updateDate("e6b21190d0f940a789dd78ef3eb3e2ac",
                "9c2e1b0c74cb4755a8ea67f7e8ab8c95",
                "authorization_code",
                "http://yourcallback.com", code).enqueue(new Callback<AccessToken>(){
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                User user = response.body().getUser();
                String userInfo = gson.toJson(user);

                Intent intent = new Intent(MainActivity.this, UserInfo.class);
                intent.putExtra("info", userInfo);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                call.toString();
            }

        });

    }

}


