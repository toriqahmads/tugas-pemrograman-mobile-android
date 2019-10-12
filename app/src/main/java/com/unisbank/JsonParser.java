package com.unisbank;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

public class JsonParser {
    public static String getJson(Context context){
        try{
            String json;
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            return json;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
