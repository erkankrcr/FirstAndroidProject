package com.example.erkan.odev;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class ListFrag extends Fragment {
    String[] ulkeler = {"Türkiye", "Japonya", "Rusya", "Uganda",
            "Almanya", "Meksika", "Hollanda", "Çin Halk Cumhuryeti", "İskoçya", "Fransa", "Amerika Birleşik Devletleri"};
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listfrag,container,false);
        ListView listView = view.findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.cell,R.id.cell,ulkeler);
        listView.setAdapter(adapter);
        ((Button) view.findViewById(R.id.LogOUT)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences.Editor editor = getActivity()
                        .getSharedPreferences("User",MODE_PRIVATE).edit();
                editor.putBoolean("RememberMe",false);
                editor.commit();
                Intent intent = new Intent(getActivity(),open_splash.class);
                startActivity(intent);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BilgiFrag frag = new BilgiFrag();
                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                frag.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.listfrag,frag).commit();


            }
        });
        return view;
    }
}
