package com.example.android.savecleartext;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.savecleartext.R;

public class MainActivity extends AppCompatActivity {
    private Button save;
    private Button clear;
    private EditText editText;
    String text_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = (Button) findViewById(R.id.save);
        editText = (EditText) findViewById(R.id.editText);
        clear = (Button) findViewById(R.id.clear);

        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        text_info = sharedPreferences.getString(getString(R.string.TEXT_INFO),"");
        editText.setText(text_info);
    }

    public void savefn(View view){
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.TEXT_INFO),editText.getText().toString());
        editor.commit();

    }

    public void clearfn(View view)
    {
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        editText.setText("");
    }
}