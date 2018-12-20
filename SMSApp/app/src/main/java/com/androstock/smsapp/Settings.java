package com.androstock.smsapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends Activity {
    // Switch that will target dark mode
    Switch darkMode;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        darkMode = findViewById(R.id.dark_mode);
        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                   SharedPreferences.Editor editor = sharedPref.edit();
                   editor.putString("themeChoice","Dark");
                   editor.commit();

                }
                else{
                    SharedPreferences.Editor editor = sharedPref.edit();
                    setTheme(android.R.style.Theme_Material_Light);
                    editor.putString("themeChoice","Light");
                    editor.commit();

                }
            }
        });
    }
}
