package com.unisbank;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class ProfileDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiledosen);

        ProfileDosenActivity.this.setTitle("Profil Dosen");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_unisbank);
        actionBar.setDisplayUseLogoEnabled(true);

        final TextView nama = (TextView) findViewById(R.id.nama);
        final TextView namaval = (TextView) findViewById(R.id.namalengkapval);
        final TextView email = (TextView) findViewById(R.id.emailval);
        final TextView minat = (TextView) findViewById(R.id.minatval);
        final TextView vitate = (TextView) findViewById(R.id.vitate);
        final ImageView foto = (ImageView) findViewById(R.id.foto);

        nama.setText(getIntent().getStringExtra("nama"));
        namaval.setText(getIntent().getStringExtra("nama"));
        email.setText(getIntent().getStringExtra("email"));
        minat.setText(getIntent().getStringExtra("minat"));
        vitate.setText(getIntent().getStringExtra("vitate"));

        new DownloadImage(foto).execute(getIntent().getStringExtra("foto"));

        Button kembali = (Button) findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImage(ImageView imageView){
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... url){
            String imageURL = url[0];
            Bitmap bimage = null;
            try{
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }
}