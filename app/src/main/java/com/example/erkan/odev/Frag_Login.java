package com.example.erkan.odev;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Frag_Login extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater ,ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_login,container,false);
        final SharedPreferences.Editor editor = getActivity().getSharedPreferences("User",MODE_PRIVATE).edit();
        final SharedPreferences preferences = getActivity().getSharedPreferences("User",MODE_PRIVATE);
        final EditText IDEt = view.findViewById(R.id.LEt1);
        final EditText PassEt = view.findViewById(R.id.LEt2);
        final Switch SbEt = view.findViewById(R.id.RememberMe);

        view.findViewById(R.id.Lbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = IDEt.getText().toString();
                String Pass = PassEt.getText().toString();
                String BID = preferences.getString("ID","Null");
                String BPass = preferences.getString("Pass","Null");
                if(ID.equals(BID) && Pass.equals(BPass)){
                    Intent intent = new Intent(getActivity(),Login_Splash.class);
                   if(SbEt.isChecked()){
                       editor.putBoolean("RememberMe",true);
                       editor.commit();
                   }
                    startActivity(intent);
                }else if(ID.equals("") || Pass.equals("")){
                        Toast.makeText(getActivity(),"Kullanıcı Adı Yada Şifre Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
                }else if(BID == "Null" && BPass == "Null"){
                        Toast.makeText(getActivity(),"Böyle Bir Kullanıcı Adı Yada Şifre Bulunmamaktadır. Lütfen Kayıt Olunuz!",Toast.LENGTH_SHORT).show();
                }else{
                        Toast.makeText(getActivity(),"Yanlış Kullanıcı Adı Veya Şifresi",Toast.LENGTH_SHORT).show();
                    }
                }

        });

        return view;
    }
}
