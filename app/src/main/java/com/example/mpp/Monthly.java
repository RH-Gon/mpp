package com.example.mpp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


public class Monthly extends AppCompatActivity {

    TextView calendarText;

    public final String PREFERENCE = "com.example.mpp.sharedpreference";
    public final String state = "state";


    public void setPreference(String key, int value) {
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly);

        calendarText  = (TextView) findViewById(R.id.calendarText);

        Toolbar tb = (Toolbar) findViewById(R.id.monthlyBar);
        setSupportActionBar(tb);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater barInflater = getMenuInflater();
        barInflater.inflate(R.menu.appbar_action, menu);
        menu.getItem(3).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // 추가를 눌렀을때
                return true;
            case R.id.action_search:
                // 검색을 눌렀을때
                return true;
            case R.id.action_list:
                Intent intentList = new Intent(getApplicationContext(), List.class);
                startActivity(intentList);
                finish();
                return true;
            case R.id.action_monthly:
                return true;
            case R.id.action_weekly:
                Intent intentWeekly = new Intent(getApplicationContext(), Weekly.class);
                startActivity(intentWeekly);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStop() {
        setPreference(state, 1); // monthly에서 종료시 스테이트 값 1으로 반환
        super.onStop();
    }
}
