package com.example.erkan.odev;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import static android.content.Context.MODE_PRIVATE;


public class Fragment_Kayit extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sign,container,false);

        final EditText IDEt = view.findViewById(R.id.Sign_IDEt);
        final EditText PassEt = view.findViewById(R.id.Sign_PassEt);
        final EditText PassTekrarEt = view.findViewById(R.id.Sign_PassTekrarEt);
        final SharedPreferences.Editor editor = getActivity().getSharedPreferences("User",MODE_PRIVATE).edit();

        view.findViewById(R.id.Sbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ID = IDEt.getText().toString();
                String Pass = PassEt.getText().toString();
                String PassT = PassTekrarEt.getText().toString();

                Intent intent = new Intent(getActivity(),Login_Splash.class);
                if("".equals(ID) || "".equals(Pass) || "".equals(PassT) ){
                    Toast.makeText(getActivity(),"Alanlar Boş Girilemez",Toast.LENGTH_SHORT).show();
                }else if(!(Pass.equals(PassT))){
                    Toast.makeText(getActivity(),"Şifreler Uyuşmuyor",Toast.LENGTH_SHORT).show();
                }else{
                    editor.clear();
                    editor.putString("ID",ID);
                    editor.putString("Pass",Pass);
                    editor.commit();
                    startActivity(intent);
                }


            }
        });
        return view;
    }
}
