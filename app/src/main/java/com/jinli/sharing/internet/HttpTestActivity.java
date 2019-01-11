package com.jinli.sharing.internet;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jinli.sharing.R;
import com.jinli.sharing.model.response.LoginResponse;

/**
 * Created by Jin on 1/10/2019
 */
public class HttpTestActivity extends AppCompatActivity {

    private HttpTestViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        viewModel = ViewModelProviders.of(this).get(HttpTestViewModel.class);
        viewModel.userLiveData.observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(@Nullable LoginResponse loginResponse) {
                Toast.makeText(HttpTestActivity.this, " 用户名是 "
                        + loginResponse.getName() + ",年龄是" + loginResponse.getAge(), Toast.LENGTH_LONG).show();
            }
        });
        Button button = findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.loadUser();
            }
        });


    }
}
