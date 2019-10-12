package com.unisbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.widget.AdapterView.*;

public class DosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dosen);

        String title = "Dosen " + getIntent().getStringExtra("progdiPanjang");

        DosenActivity.this.setTitle(title);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_unisbank);
        actionBar.setDisplayUseLogoEnabled(true);

        String progdi = getIntent().getStringExtra("progdi");
        try{
            JSONObject data = new JSONObject(JsonParser.getJson(getApplicationContext()));
            JSONObject dosenprogdi = data.getJSONObject("dosen");
            JSONArray list = dosenprogdi.getJSONArray(progdi);

            final ArrayList<HashMap<String, String>> prolist = new ArrayList<>();

            for(int i=0; i < list.length(); i++){
                JSONObject profile = list.getJSONObject(i);

                String id = profile.getString("id");
                String nama = profile.getString("nama_lengkap");
                String email = profile.getString("email");
                String minat = profile.getString("minat");
                String vitate = profile.getString("vitate");
                String foto = profile.getString("foto");

                HashMap<String, String> pro = new HashMap<>();

                pro.put("id", id);
                pro.put("nama", nama);
                pro.put("email", email);
                pro.put("minat", minat);
                pro.put("vitate", vitate);
                pro.put("foto", foto);

                prolist.add(pro);
            }

            ListView lv = (ListView) findViewById(R.id.dosenlist);

            ListAdapter adapter = new SimpleAdapter(DosenActivity.this, prolist,
                    R.layout.listdosen,
                    new String[]{"nama", "email"},
                    new int[]{R.id.nama, R.id.email});
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView <?> adapter, View view, int position, long id){
                    Intent profileDosen = new Intent(DosenActivity.this, ProfileDosenActivity.class);
                    HashMap<String, String> data = prolist.get(position);
                    profileDosen.putExtra("id", data.get("id"));
                    profileDosen.putExtra("nama", data.get("nama"));
                    profileDosen.putExtra("email", data.get("email"));
                    profileDosen.putExtra("minat", data.get("minat"));
                    profileDosen.putExtra("vitate", data.get("vitate"));
                    profileDosen.putExtra("foto", data.get("foto"));
                    startActivity(profileDosen);
                }
            });

            Button kembali = (Button) findViewById(R.id.kembali);
            kembali.setOnClickListener(new OnClickListener() {
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