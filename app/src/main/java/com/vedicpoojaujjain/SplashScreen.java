package com.vedicpoojaujjain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashScreen extends AppCompatActivity {


    private FirebaseAuth mAuth;
    String emailfire,passfire;
    ConnectivityManager connectivityManager;
    Boolean check;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        emailfire="v1@gmail.com";
        passfire="1234567890";
        mAuth = FirebaseAuth.getInstance();
            connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);


            if(connectivityManager.getActiveNetworkInfo()!=null &&
                    connectivityManager.getActiveNetworkInfo().isConnected() &&
                    connectivityManager.getActiveNetworkInfo().isAvailable()) {

                mAuth.signInWithEmailAndPassword(emailfire, passfire).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Welcome To Ujjain Vedic Pooja", Toast.LENGTH_LONG).show();
                                }

                            }, 2000);


                        }
                        else
                            {
                            Toast.makeText(getApplicationContext(), "Update App", Toast.LENGTH_LONG).show();
                            TextView textView;
                            textView=findViewById(R.id.update);
                            textView.setVisibility(View.VISIBLE);
                            textView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1d_2kX7pudB8BFj0Sy25jtrFgT_MITyEu"));
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                });




            }
            else {
                Toast.makeText(getApplicationContext(),"Check Your Internet Connetion",Toast.LENGTH_LONG).show();
            }


                    }




}


