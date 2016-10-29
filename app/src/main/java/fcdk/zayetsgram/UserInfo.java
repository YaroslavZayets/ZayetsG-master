package fcdk.zayetsgram;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fcdk.zayetsgram.data.User;
import fcdk.zayetsgram.databinding.UserinfoBinding;


public class UserInfo extends Activity {

    Gson gson = new GsonBuilder().create();
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserinfoBinding binding = DataBindingUtil.setContentView(this, R.layout.userinfo);
        Intent intent = getIntent();

        String userInfo = intent.getStringExtra("info");
        user = gson.fromJson(userInfo, User.class);
        binding.setUser(user);


    }





}
