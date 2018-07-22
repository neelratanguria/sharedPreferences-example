package com.flameshot.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArraySet<String> arraySet = new ArraySet<>();
        SharedPreferences pref = getSharedPreferences("com.flameshot.sharedpreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        arraySet.add("udemy");
        arraySet.add("Guitar");
        arraySet.add("work");

        editor.putInt("udemy", 12);
        editor.putStringSet("List", arraySet);
        editor.commit();
    }

    public void clicked(View view)
    {
        SharedPreferences pref = getSharedPreferences("com.flameshot.sharedpreference", Context.MODE_PRIVATE);
        int x;
        x = pref.getInt("udemy", 0);
        ArraySet<String> getstr = new ArraySet<>();
        for (String name: pref.getStringSet("List",null))
        {
            getstr.add(name);
            Log.e( "onCreate: getInt", name);
        }
    }
}
