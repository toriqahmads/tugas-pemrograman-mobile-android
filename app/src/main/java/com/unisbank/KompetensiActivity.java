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

public class KompetensiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kompetensi);
        String progdi = getIntent().getStringExtra("progdi");
        String title = "Kompetensi " + getIntent().getStringExtra("progdiPanjang");

        KompetensiActivity.this.setTitle(title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_unisbank_foreground);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setElevation(0);

        try{
            JSONObject data = new JSONObject(JsonParser.getJson(getApplicationContext()));
            JSONObject komp = data.getJSONObject("kompetensi");
            String kompetensi = komp.getString(progdi);

            final TextView kompetensiView = (TextView) findViewById(R.id.kompetensi);

            kompetensiView.setText(kompetensi);

            Button kembali = (Button) findViewById(R.id.kembali);

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
