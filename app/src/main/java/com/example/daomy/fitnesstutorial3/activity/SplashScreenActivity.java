package com.example.daomy.fitnesstutorial3.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.daomy.fitnesstutorial3.R;
import com.example.daomy.fitnesstutorial3.database.SQLiteHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by daomy on 5/5/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {
    protected boolean _active = true;
    protected int _splashTime = 1000;
    public static SQLiteHelper sqLiteHelper;
    String linkimage = "";

    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_sceen);
        sqLiteHelper = new SQLiteHelper(this, "Baitap.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS BAITAP(Id INTEGER PRIMARY KEY AUTOINCREMENT,type VARCHAR ,ten VARCHAR,tage VARCHAR,tagn VARCHAR,tagh VARCHAR,info VARCHAR,image BLOB )");

        // thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (InterruptedException e) {

                } finally {
                    finish();
                    Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    SplashScreenActivity.this.startActivity(mainIntent);
                    SplashScreenActivity.this.finish();
                }
            }
        };
        splashTread.start();
    }
    public  byte[] getUrlBytes(String sUrl)throws IOException {
        URL url  =new URL(sUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = connection.getInputStream();
            if(connection.getResponseCode()!= HttpURLConnection.HTTP_OK){
                throw  new IOException(connection.getResponseMessage());
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int byteRead = 0;
            byte[] buffer = new byte[1024];
            while ((byteRead = in.read(buffer))>0){
                out.write(buffer,0,byteRead);
            }
            out.close();
            return  out.toByteArray();
        }finally {
            connection.disconnect();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }
}


