package com.unisbank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class VisiMisiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visimisi);

        String title = "Visi & Misi " + getIntent().getStringExtra("progdiPanjang");

        VisiMisiActivity.this.setTitle(title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_unisbank);
        actionBar.setDisplayUseLogoEnabled(true);

        String progdi = getIntent().getStringExtra("progdi");

        try{
            JSONObject data = new JSONObject(JsonParser.getJson(getApplicationContext()));
            JSONObject visimisi = data.getJSONObject("visimisi");

            JSONObject prog = visimisi.getJSONObject(progdi);
            String visi = prog.getString("visi");
            String misi = prog.getString("misi");

            final TextView visiView = (TextView) findViewById(R.id.visi);
            final TextView misiView = (TextView) findViewById(R.id.misi);

            Button kembali = (Button) findViewById(R.id.kembali);

            visiView.setText(visi);
            misiView.setText(misi);

            kembali.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
}