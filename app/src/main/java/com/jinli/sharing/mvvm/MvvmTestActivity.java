package com.jinli.sharing.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jinli.sharing.R;

/**
 * Created by Jin on 1/10/2019
 */
public class MvvmTestActivity extends AppCompatActivity {

    private MvvmTestViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        viewModel = ViewModelProviders.of(this).get(MvvmTestViewModel.class);
        Button button = findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getUser().observe(MvvmTestActivity.this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User user) {
                        Toast.makeText(MvvmTestActivity.this, " 用户名是 "
                                + user.getName() + ",年龄是" + user.getAge(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
