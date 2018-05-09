package com.example.android.savecleartext;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
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
        //Here starts the context menu stuff (along with menu.xml)

        editText.setTextIsSelectable(true);
        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback()
        {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu)
            {
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.menu, menu);
                return true;
            }
            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu)
            {
                return false;
            }
            @Override
            public boolean onActionItemClicked(ActionMode actionMode,MenuItem menuItem)
            {
                switch(menuItem.getItemId())
                {
                    case R.id.bold:
                        editText.setTypeface(null,Typeface.BOLD);
                        return true;
                    case R.id.italic:
                        editText.setTypeface(null,Typeface.ITALIC);
                        return true;
                    case R.id.bolditalic:
                        editText.setTypeface(null, Typeface.BOLD_ITALIC);
                        return true;
                    default:
                        return false;
                }
            }
            @Override
            public void onDestroyActionMode(ActionMode actionMode)
            {

            }


        });

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