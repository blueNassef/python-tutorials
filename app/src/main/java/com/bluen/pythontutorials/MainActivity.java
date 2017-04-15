package com.bluen.pythontutorials;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.apptracker.android.track.AppTracker;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppTracker.startSession(getApplicationContext(),
                "O3YWhw1wo0GBqgyk4c0MSW4hy9GBLuzS",AppTracker.ENABLE_AUTO_CACHE);

        AppTracker.loadModuleToCache(getApplicationContext(),"inapp");


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        ImageView logo= (ImageView) findViewById(R.id.logo);
        final AlphaAnimation anim= new AlphaAnimation(5f, 0f);
        anim.setDuration(5000);
        logo.startAnimation(anim);

        final String [] Tuts= getResources().getStringArray(R.array.tuts);
        final ArrayAdapter<String> adap=
                new ArrayAdapter<>(this, R.layout.custom_listview,Tuts);
        lv= (ListView) findViewById(R.id.listView);
        lv.setAdapter(adap);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                lv.setVisibility(View.VISIBLE);}
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValue= (String) lv.getItemAtPosition(position);
                SoundPool sp= new SoundPool(5, AudioManager.STREAM_MUSIC,0);
                int soundId= sp.load(getBaseContext(),R.raw.bsound,1);

                android.app.FragmentManager fm= getFragmentManager();
                android.app.FragmentTransaction ft= fm.beginTransaction();

                switch (position){
                    case 0:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        ft.add(R.id.fragContainer,new introClass());
                        ft.addToBackStack("");
                        ft.commit();
                        break;
                    case 1:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        ft.add(R.id.fragContainer,new helloWorld());
                        ft.addToBackStack("");
                        ft.commit();
                        break;
                    case 2:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new improvingFirstFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 3:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new assertTrueFlaseFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 4:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new beforeAfterFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 5:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new beforeClassAfterClassFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 6:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new comparingArraysFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 7:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new exceptionsHandlingFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 8:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new performanceTestFrag());
                        ft.addToBackStack("");
                        // ft.commit();
                        break;
                    case 9:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        //ft.add(R.id.fragContainer,new parametrizedTestFrag());
                        ft.addToBackStack("");
                        //ft.commit();
                        break;
                    case 10:
                        sp.play(soundId,1,1,0,0,1);
                        Toast.makeText(getApplicationContext(),itemValue,
                                Toast.LENGTH_SHORT).show();
                        // ft.add(R.id.fragContainer,new testSuitesFrag());
                        ft.addToBackStack("");
                        // ft.commit();
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about :
                android.app.FragmentManager fm= getFragmentManager();
                android.app.FragmentTransaction ft= fm.beginTransaction();
                ft.add(R.id.fragContainer,new aboutFrag());
                ft.addToBackStack("");
                ft.commit();
                return true;
            case R.id.contact:
                Intent mail= new Intent(Intent.ACTION_SEND);
                mail.setType("text/plain");
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"bluen.dev@gmail.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, "junit tutorial");
                mail.putExtra(Intent.EXTRA_TEXT,"body of email");
                try{
                    startActivity(Intent.createChooser(mail,"Send mail..."));
                }catch(android.content.ActivityNotFoundException e){
                    Toast.makeText(this,"Error...\ntry again later",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.exit :
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void gameOver() {
        if(AppTracker.isAdReady("inapp")) {
            AppTracker.loadModule(getApplicationContext(),"inapp");
        }
    }

    @Override
    public void onBackPressed() {
        gameOver();
        super.onBackPressed();
    }
}
