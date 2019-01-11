package com.jinli.sharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jinli.sharing.db.DbActivity;
import com.jinli.sharing.internet.HttpTestActivity;
import com.jinli.sharing.mvvm.MvvmTestActivity;
import com.jinli.sharing.util.SPUtils;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnMvvm = findViewById(R.id.btn_mvvm);
        btnMvvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MvvmTestActivity.class));
            }
        });
        Button btnInternet = findViewById(R.id.btn_internet);
        btnInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HttpTestActivity.class));
            }
        });
        Button btnFragment = findViewById(R.id.btn_fragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PagerActivity.class));
            }
        });
        Button btnDB = findViewById(R.id.btn_db);
        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DbActivity.class));
            }
        });
        Button btnSharePreferences = findViewById(R.id.btn_sp);
        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils spUtils = SPUtils.getInstance(MainActivity.this, "SP");
                spUtils.putString("UserName", "Tom");
                String userName = spUtils.getString("UserName", "Mary");
                Log.i(TAG, "userName = " + userName);
            }
        });
    }
}
