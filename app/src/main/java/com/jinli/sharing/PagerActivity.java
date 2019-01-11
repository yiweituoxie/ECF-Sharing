package com.jinli.sharing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jinli.sharing.fragment.Fragment1;
import com.jinli.sharing.fragment.Fragment2;
import com.jinli.sharing.fragment.Fragment3;
import com.jinli.sharing.fragment.Fragment4;

/**
 * Created by Jin on 1/11/2019
 */
public class PagerActivity extends AppCompatActivity {

    private TextView marketBar;
    private TextView hatBar;
    private TextView messageBar;
    private TextView centerBar;

    Fragment1 giftFragment;
    Fragment2 hatFragment;
    Fragment3 messageFragment;
    Fragment4 centerFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        marketBar = findViewById(R.id.bar_market);
        hatBar = findViewById(R.id.bar_hat);
        messageBar = findViewById(R.id.bar_message);
        centerBar = findViewById(R.id.bar_center);

        marketBar.setClickable(true);
        hatBar.setClickable(true);
        messageBar.setClickable(true);
        centerBar.setClickable(true);

        setAllNotSelected();
        marketBar.setSelected(true);

        giftFragment = new Fragment1();
        hatFragment = new Fragment2();
        messageFragment = new Fragment3();
        centerFragment = new Fragment4();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment, giftFragment).commit();

    }


    private void setAllNotSelected() {
        marketBar.setSelected(false);
        hatBar.setSelected(false);
        messageBar.setSelected(false);
        centerBar.setSelected(false);
    }

    public void tabSelect(View v) {
        setAllNotSelected();
        switch (v.getId()) {
            case R.id.bar_market:
                marketBar.setSelected(true);
                fragmentManager.beginTransaction().replace(R.id.main_fragment, giftFragment).commit();
                break;
            case R.id.bar_hat:
                hatBar.setSelected(true);
                fragmentManager.beginTransaction().replace(R.id.main_fragment, hatFragment).commit();
                break;
            case R.id.bar_message:
                messageBar.setSelected(true);
                fragmentManager.beginTransaction().replace(R.id.main_fragment, messageFragment).commit();
                break;
            case R.id.bar_center:
                centerBar.setSelected(true);
                fragmentManager.beginTransaction().replace(R.id.main_fragment, centerFragment).commit();
                break;
            default:
                break;
        }
    }

}

