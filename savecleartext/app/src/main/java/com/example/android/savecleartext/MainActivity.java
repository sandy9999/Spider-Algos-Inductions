package com.android.example.savecleartext;

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
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = (Button) findViewById(R.id.save);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void savefn(){
        String s = editText.getText().toString();
        editText.setText(s);
    }
}