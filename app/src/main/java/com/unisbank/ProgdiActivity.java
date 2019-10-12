package com.unisbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ProgdiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progdi);

        ProgdiActivity.this.setTitle(getIntent().getStringExtra("progdiPanjang"));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_unisbank_round);
        actionBar.setDisplayUseLogoEnabled(true);

        Button visimisi = (Button) findViewById(R.id.visimisi);
        Button dosen = (Button) findViewById(R.id.dosen);
        Button kompetensi = (Button) findViewById(R.id.kompetensi);
        Button kembali = (Button) findViewById(R.id.kembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        visimisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visimisi = new Intent(ProgdiActivity.this, VisiMisiActivity.class);
                visimisi.putExtra("progdi", getIntent().getStringExtra("progdi"));
                visimisi.putExtra("progdiPanjang", getIntent().getStringExtra("progdiPanjang"));
                startActivity(visimisi);
            }
        });

        kompetensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kompetensi = new Intent(ProgdiActivity.this, KompetensiActivity.class);
                kompetensi.putExtra("progdi", getIntent().getStringExtra("progdi"));
                kompetensi.putExtra("progdiPanjang", getIntent().getStringExtra("progdiPanjang"));
                startActivity(kompetensi);
            }
        });

        dosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dosen = new Intent(ProgdiActivity.this, DosenActivity.class);
                dosen.putExtra("progdi", getIntent().getStringExtra("progdi"));
                dosen.putExtra("progdiPanjang", getIntent().getStringExtra("progdiPanjang"));
                startActivity(dosen);
            }
        });
    }
}