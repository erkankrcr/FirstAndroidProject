package com.example.erkan.odev;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Et1 = findViewById(R.id.LEt1);
        final EditText Et2 = findViewById(R.id.LEt2);
        Switch sw = findViewById(R.id.Switch);
        final TextView Logintv = findViewById(R.id.Signtv);
        final TextView Signtv = findViewById(R.id.Logtv);
        SharedPreferences preferences = getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Boolean RememberMe = preferences.getBoolean("RememberMe",false);
        if(RememberMe){
            Intent intent = new Intent(MainActivity.this,Login_Splash.class);
            startActivity(intent);
        }
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.frag,new Frag_Login()).commit();

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Signtv.setVisibility(Signtv.INVISIBLE);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag,new Fragment_Kayit());
                    ft.commit();
                    Logintv.setVisibility(Logintv.VISIBLE);

                }else{
                    Logintv.setVisibility(Logintv.INVISIBLE);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag,new Frag_Login());
                    ft.commit();
                    Signtv.setVisibility(Logintv.VISIBLE);
                }
            }
        });





    }
}
