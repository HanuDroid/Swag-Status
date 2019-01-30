package com.ayansh.swagstatus.android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ayansh.hanudroid.Application;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getFragmentManager().beginTransaction().replace(R.id.content_frame, new MyPreferenceFragment()).commit();

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Application app = Application.getApplicationInstance();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean preference_value;

        if(key.contentEquals("show_memes")){

            preference_value = sharedPref.getBoolean("show_memes",true);

            if(preference_value){
                app.addSyncCategory("Meme");
            }
            else{
                app.removeSyncCategory("Meme");
            }

        }

        if(key.contentEquals("love_status")){

            preference_value = sharedPref.getBoolean("love_status",true);

            if(preference_value){
                app.addSyncCategory("Love");
            }
            else{
                app.removeSyncCategory("Love");
            }

        }

        if(key.contentEquals("sad_status")){

            preference_value = sharedPref.getBoolean("sad_status",true);

            if(preference_value){
                app.addSyncCategory("Sad");
            }
            else{
                app.removeSyncCategory("Sad");
            }

        }

        if(key.contentEquals("inspirational_status")){

            preference_value = sharedPref.getBoolean("inspirational_status",true);

            if(preference_value){
                app.addSyncCategory("Inspirational");
            }
            else{
                app.removeSyncCategory("Inspirational");
            }

        }

        if(key.contentEquals("funny_status")){

            preference_value = sharedPref.getBoolean("funny_status",true);

            if(preference_value){
                app.addSyncCategory("Funny");
            }
            else{
                app.removeSyncCategory("Funny");
            }

        }

    }

    public static class MyPreferenceFragment extends PreferenceFragment {

        @Override
        public void onCreate(final Bundle savedInstanceState){

            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }

    }
}