package com.example.erkan.odev;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class Activity_ListFrag extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_frag);
        FragmentManager manager = getFragmentManager();
        ListFrag listFrag = new ListFrag();
        manager.beginTransaction().replace(R.id.listfrag,listFrag).commit();
    }
}
