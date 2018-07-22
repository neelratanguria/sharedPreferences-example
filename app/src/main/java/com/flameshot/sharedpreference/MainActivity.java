package com.flameshot.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText addString;
    String buffer;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArraySet<String> arraySet = new ArraySet<>();
        pref = getSharedPreferences("com.flameshot.sharedpreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        addString = findViewById(R.id.input);


        editor.putInt("udemy", 12);
        editor.putStringSet( "List",null);
        editor.commit();
    }

    public void clicked(View view)
    {
        pref = getSharedPreferences("com.flameshot.sharedpreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        ArraySet<String> getstr = new ArraySet<>();
        ArraySet<String> setstr = new ArraySet<>();

        buffer = addString.getText().toString().trim().toLowerCase();

        if (!(buffer.matches("")))
        {
            String m = pref.getStringSet("List", null).toString();
            if (m != "[]")
            {
                for (String name: pref.getStringSet("List",null))
                {
                    setstr.add(name);
                }
                setstr.add(buffer);
                editor.putInt(buffer, 0);
            }
            else
            {
                setstr.add(buffer);
                editor.putInt(buffer, 0);
            }
            editor.putStringSet("List", setstr);
            editor.apply();
            editor.commit();

            for (String name: pref.getStringSet("List",null))
            {
                getstr.add(name);
                Log.e( "onCreate: getInt", name);
                Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void get(View view)
    {
        for(String name: pref.getStringSet("List",null))
        {
            Log.e( "get: Values", name+ " " + pref.getInt(name,0));
        }
    }
}
