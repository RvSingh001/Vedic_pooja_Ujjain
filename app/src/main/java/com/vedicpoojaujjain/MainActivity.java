package com.vedicpoojaujjain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.LayoutTransition;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList arrayList;
    private ViewFlipper myViewFlipper;
    private float initialXPoint;
    int[] image = { R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h,
             R.drawable.k};
    ImageView whastapp,phone;
    LinearLayout linearLayout;
    TextView allpooja,parichay;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar=findViewById(R.id.toolbr);
//        setSupportActionBar(toolbar);

//        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        TextView button;
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbarview);
        button=(TextView) actionBar.getCustomView().findViewById(R.id.share);


        MobileAds.initialize(this, "ca-app-pub-7170790412463597~3003144075");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7170790412463597/6021023805");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        myViewFlipper = (ViewFlipper) findViewById(R.id.viewfilp);
        whastapp = findViewById(R.id.whatsapp);
        phone = findViewById(R.id.phone);
        gridView = findViewById(R.id.simpleGridView);
        linearLayout=findViewById(R.id.linear);
        allpooja=findViewById(R.id.allpooja);
        parichay=findViewById(R.id.परिचय);
        Resources resources = getResources();
        String[] strings = getResources().getStringArray(R.array.pooja_path);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, R.layout.gridview, strings);
        ViewGroup.LayoutParams layoutParams=gridView.getLayoutParams();
        gridView.setLayoutParams(layoutParams);
        gridView.setAdapter(arrayAdapter);
//        ProgressDialog progressDialog=new ProgressDialog(this);
//        progressDialog.setMessage("Please Wait...");
        final int[] j = new int[1];
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIntAd();
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"https://drive.google.com/drive/folders/1d_2kX7pudB8BFj0Sy25jtrFgT_MITyEu");
                Toast.makeText(getApplicationContext(),"Share this app with others",Toast.LENGTH_LONG).show();
                startActivity(Intent.createChooser(intent,"Share App"));
            }
        });
        parichay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIntAd1();
                Intent intent = new Intent(MainActivity.this, Poojades.class);
                intent.putExtra("Pooja", "परिचय");
                startActivity(intent);
            }
        });
        allpooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIntAd1();
                Intent intent = new Intent(MainActivity.this, Poojades.class);
                intent.putExtra("Pooja", "हमारे द्वारा की जाने वाली पूजा");
                startActivity(intent);
            }
        });
        gridView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {

            loadIntAd1();
//            progressDialog.show();
            String string = gridView.getItemAtPosition(position).toString();
            Intent intent1=new Intent(this,Poojades.class);
            intent1.putExtra("Pooja", string);
            startActivity(intent1);

        });


        for (int i = 0; i < image.length; i++) {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(image[i]);
            myViewFlipper.addView(imageView);
        }
        myViewFlipper.startFlipping();
        whastapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIntAd2();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Contact With Dharmendra Sharma On Whatsapp ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/917693823632"));
                                startActivity(intent);


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Send Message On Whatsapp");
                alert.show();



            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadIntAd2();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to Contact With Dharmendra Sharma On Call ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();

                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "7693823632", null)));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Call");
                alert.show();



            }
        });
        linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                loadIntAd();
                BottomSheet bottomSheet=new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(),"Modal Bottom Sheet");
                return false;
            }
        });

    }

    public void loadIntAd() {
        AdRequest adRequest1 = new AdRequest.Builder().build();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {

            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        InterstitialAd.load(this,"ca-app-pub-7170790412463597/3438984695", adRequest1, new InterstitialAdLoadCallback() {
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

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;


                    }
                });
                mInterstitialAd.show(MainActivity.this);

            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;

            }
        });
    }
    public void loadIntAd1()
    {
        AdRequest adRequest1 = new AdRequest.Builder().build();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        InterstitialAd.load(this,"ca-app-pub-7170790412463597/1660010921", adRequest1, new InterstitialAdLoadCallback() {
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

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;

                    }
                });
                mInterstitialAd.show(MainActivity.this);
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                mInterstitialAd = null;
            }
        });



    }
    public void loadIntAd2() {
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

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                    }
                });
                mInterstitialAd.show(MainActivity.this);
            }
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                mInterstitialAd = null;
            }
        });

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
                loadIntAd();
               BottomSheet bottomSheet=new BottomSheet();
               bottomSheet.show(getSupportFragmentManager(),"ModalBottomSheet");


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}