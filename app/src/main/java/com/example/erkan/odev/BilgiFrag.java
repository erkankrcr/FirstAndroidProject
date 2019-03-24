package com.example.erkan.odev;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BilgiFrag extends Fragment {
    String[] ulkeler = {"Türkiye", "Japonya", "Rusya", "Uganda",
            "Almanya", "Meksika", "Hollanda", "Çin Halk Cumhuryeti", "İskoçya", "Fransa", "Amerika Birleşik Devletleri"};
    String[] ulkeBilgileri = {"Türkiye ya da resmî adıyla Türkiye Cumhuriyeti, topraklarının büyük bölümü Anadolu'ya, küçük bir bölümü ise Balkanlar'ın uzantısı olan Trakya'ya yayılmış bir ülke.",
            "Japonya, Doğu Asya'da bir ada ülkesidir. Büyük Okyanus'ta bulunan Japonya Japon Denizi'nden Çin, Kuzey Kore, Güney Kore ve Rusya'nın doğusuna, kuzeyde Ohotsk Denizi'nden güneyde Doğu Çin Denizi'ne ve Tayvan'a kadar uzanır. Japonca adını oluşturan kanji karakterler 'güneş' ve 'köken' anlamına gelir.",
            "Rusya veya resmî adıyla Rusya Federasyonu, kuzey Avrasya'da bir ülkedir. Yönetim şekli federal yarı başkanlık tipi cumhuriyettir.",
            "Uganda ya da resmî adıyla Uganda Cumhuriyeti, Afrika kıtasının doğu kesiminde yer alan ve denize kıyısı olmayan bir kara ülkesidir.",
            "Almanya ya da resmî adıyla Almanya Federal Cumhuriyeti, Orta Avrupa'da bir ülkedir. Kuzeyinde Kuzey Denizi, Danimarka, ve Baltık Denizi; doğusunda Polonya ve Çek Cumhuriyeti; güneyinde Avusturya ve İsviçre; ve batısında Fransa, Lüksemburg, Belçika, ve Hollanda bulunur.",
            "Meksika, resmî adıyla Meksika Birleşik Devletleri, Kuzey Amerika'nın güney yarısında yer alan federal cumhuriyet. Kuzeyde Amerika Birleşik Devletleri; güney ve batıda Atlas Okyanusu; güneydoğuda Guatemala, Belize ve Karayip Denizi; doğuda ise Meksika Körfezi ile komşudur.",
            "Hollanda, Hollanda Krallığı'nı meydana getiren dört ülkeden biri. Topraklarının çok büyük bir kısmı Batı Avrupa'dadır, ayrıca Karayipler'de üç adası bulunmaktadır. Hollanda, kuzey ve batıda Kuzey Denizi, güneyde Belçika, doğuda ise Almanya ile komşudur.",
            "Çin, resmî adı ile Çin Halk Cumhuriyeti, Doğu Asya'da üniter egemen devlet. Çin Komünist Partisi tarafından tek parti rejimiyle yönetilmektedir.",
            "İskoçya, İngiltere, Galler ve Kuzey İrlanda ile birlikte Birleşik Krallık'ı oluşturan 4 ülkeden biri; İngiltere'den sonra en fazla nüfusa sahip olan 2. Birleşik Krallık ülkesidir.",
            "Fransa, ya da resmî adıyla Fransız Cumhuriyeti, ana kara toprakları Batı Avrupa'da bulunan ve dünyanın pek çok bölgesinde denizaşırı toprakları olan bir ülkedir. Kıta Fransası, güneyde Akdeniz'den kuzeyde Manş Denizi ve Kuzey Denizi'ne, doğuda Ren Nehri'nden batıda Atlas Okyanusu'na kadar yayılan topraklarda yer alır.",
            "Amerika Birleşik Devletleri 9,8 milyon kilometrekare yüzölçümüyle dünyanın toprak olarak en büyük ülkeleri arasında yer almaktadır."};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = getArguments().getInt("position",0);
        View view = inflater.inflate(R.layout.bilgifrag,container,false);
        TextView tw = view.findViewById(R.id.ulkeAd);
        TextView tw2 = view.findViewById(R.id.ulkeBilgisi);
        tw.setText(ulkeler[position]);
        tw2.setText(ulkeler[position]);
        ((TextView) view.findViewById(R.id.ulkeAd)).setText(ulkeler[position]);
        ((TextView) view.findViewById(R.id.ulkeBilgisi)).setText(ulkeBilgileri[position]);
        final FragmentManager manager = getFragmentManager();
        ((Button) view.findViewById(R.id.bilgifragbtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                       manager.beginTransaction().replace(R.id.listfrag,new ListFrag(),"ListFrag").commit();

            }
        });

        return view;
    }
}
