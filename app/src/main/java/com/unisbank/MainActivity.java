package com.unisbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.this.setTitle("Profile FTI");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_unisbank_round);
        actionBar.setDisplayUseLogoEnabled(true);

        Button ti = (Button) findViewById(R.id.ti);
        Button si = (Button) findViewById(R.id.si);
        Button mi = (Button) findViewById(R.id.mi);
        Button author = (Button) findViewById(R.id.author);
        Button keluar = (Button) findViewById(R.id.exit);

        ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent progdi = new Intent(MainActivity.this, ProgdiActivity.class);

                progdi.putExtra("progdi", "ti");
                progdi.putExtra("progdiPanjang", "Teknik Informatika");
                startActivity(progdi);
            }
        });

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent progdi = new Intent(MainActivity.this, ProgdiActivity.class);

                progdi.putExtra("progdi", "si");
                progdi.putExtra("progdiPanjang", "Sistem Informatika");
                startActivity(progdi);
            }
        });

        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent progdi = new Intent(MainActivity.this, ProgdiActivity.class);

                progdi.putExtra("progdi", "mi");
                progdi.putExtra("progdiPanjang", "Manajemen Informatika");
                startActivity(progdi);
            }
        });

        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent author = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(author);
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
