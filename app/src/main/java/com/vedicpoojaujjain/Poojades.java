package com.vedicpoojaujjain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

public class Poojades extends AppCompatActivity {
String string;
TextView textView,textView1;
InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poojades);

        MobileAds.initialize(this, "ca-app-pub-7170790412463597~3003144075");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7170790412463597/1493060787");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        string=getIntent().getStringExtra("Pooja");
        textView=findViewById(R.id.para);
        textView1=findViewById(R.id.title);
        textView1.setText(string);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadIntAd();
            }

        }, 20000);

       getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        Resources resources=getResources();
        String[] strings=getResources().getStringArray(R.array.pooja_path);
        //Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG).show();
        if(string.contains("मंगल"))
        {
            textView.setText(getResources().getString(R.string.मंगल));
        }
        else if(string.contains("सम्पूर्ण"))
        {
            textView.setText(getResources().getString(R.string.सम्पूर्ण));
        }
        else if(string.contains("हमारे"))
        {
            textView.setText(getResources().getString(R.string.हमारे));
        }
        else if(string.contains("सर्व"))
        {
            textView.setText(getResources().getString(R.string.शीघ्र));
        }
        else if(string.contains("पितृदोष"))
        {
            textView.setText(getResources().getString(R.string.पितृदोष));
        }
        else if(string.contains("वास्तु"))
        {
            textView.setText(getResources().getString(R.string.वास्तु));
        }
        else if(string.contains("परिचय"))
        {
            textView.setText(getResources().getString(R.string.परिचय));
        }
        else if(string.contains("रोग"))
        {
            textView.setText(getResources().getString(R.string.रोग));
        }
        else if(string.contains("समस्त"))
        {
//            textView.setText(getResources().getString(R.string.समस्त));
        }
        else if(string.contains("विवाह संबंधी"))
        {
//            textView.setText(getResources().getString(R.string.विवाह_संबंधी));
        }
        else if(string.contains("नवग्रह"))
        {
            textView.setText(getResources().getString(R.string.नवग्रह));
        }
        else if(string.contains("कामना"))
        {
            textView.setText(getResources().getString(R.string.कामना));
        }
        else if(string.contains("भूमि"))
        {
            textView.setText(getResources().getString(R.string.भूमि));
        }
        else if(string.contains("धन"))
        {
            textView.setText(getResources().getString(R.string.धन));
        }
        else if(string.contains("शत्रु"))
        {
            textView.setText(getResources().getString(R.string.शत्रु));
        }
        else if(string.contains("शुभ"))
        {
//            textView.setText(getResources().getString(R.string.शुभ));
        }
        else if(string.contains("शीघ्र"))
        {
            textView.setText(getResources().getString(R.string.शीघ्र));
        }
        else if(string.contains("व्यापार"))
        {
            textView.setText(getResources().getString(R.string.व्यापार));
        }
        else if(string.contains("रक्षा"))
        {
//            textView.setText(getResources().getString(R.string.रक्षा));
        }
        else if(string.contains("दुर्गासप्तशती"))
        {
//            textView.setText(getResources().getString(R.string.दुर्गासप्तशती));
        }
        else if(string.contains("श्री"))
        {
//            textView.setText(getResources().getString(R.string.श्री));
        }
        else if(string.contains("नागवली"))
        {
//            textView.setText(getResources().getString(R.string.नागवली));
        }
        else if(string.contains("गृह वास्तु"))
        {
//            textView.setText(getResources().getString(R.string.गृह_वास्तु));
        }
        else if(string.contains("गृह प्रवेश"))
        {
//            textView.setText(getResources().getString(R.string.गृह_प्रवेश));
        }
        else if(string.contains("रूद्रपाठ"))
        {
            textView.setText(getResources().getString(R.string.रूद्रपाठ));
        }
        else if(string.contains("ज्योतिष"))
        {
            textView.setText(getResources().getString(R.string.ज्योतिष));
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //menu.getItem(0).setIcon(R.drawable.ic_baseline_power_settings_new_24);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {


        switch (item.getItemId())
        {
//

            case R.id.menu_main_setting:

                BottomSheet bottomSheet=new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"ModalBottomSheet");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void loadIntAd() {
        AdRequest adRequest1 = new AdRequest.Builder().build();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        InterstitialAd.load(this,"ca-app-pub-7170790412463597/9066059352", adRequest1, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;

                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when fullscreen content failed to show.
                        loadIntAd();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"Start Ad",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Poojades.class));
                            }

                        }, 10000);

                    }
                });
                mInterstitialAd.show(Poojades.this);



            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;

            }
        });
    }
}