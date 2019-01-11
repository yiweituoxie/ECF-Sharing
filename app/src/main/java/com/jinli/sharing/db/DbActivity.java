package com.jinli.sharing.db;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jinli.sharing.R;

import java.util.List;

/**
 * Created by Jin on 1/11/2019
 */
public class DbActivity extends AppCompatActivity {

    private AppDataBase appDataBase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        appDataBase = AppDataBase.getInstance(this);


        Button buttonQuery = findViewById(R.id.btn_query);
        buttonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> users = appDataBase.getNoteDao().getUsers();
                Toast.makeText(DbActivity.this,"amount is "+users.size(),Toast.LENGTH_LONG).show();
            }
        });
        Button buttonInsert = findViewById(R.id.btn_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setAge(10);
                user.setName("Tim");
                appDataBase.getNoteDao().insertUser(
                        user
                );
            }
        });
    }
}
