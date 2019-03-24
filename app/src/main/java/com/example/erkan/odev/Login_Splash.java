package com.example.erkan.odev;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Login_Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_splash);
        SharedPreferences preferences = getSharedPreferences("User",MODE_PRIVATE);
        ((TextView) findViewById(R.id.AdTv)).setText(preferences.getString("ID","Null"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Login_Splash.this,Activity_ListFrag.class);
                startActivity(intent);
            }
        },2000);
    }
}
