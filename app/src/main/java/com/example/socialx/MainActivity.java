package com.example.socialx;

import androidx.appcompat.app.AppCompatActivity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ColorStateList csl;
    public Button main_button;
    TextView select, signup, signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        select = findViewById(R.id.select);
        main_button = findViewById(R.id.button2);

        csl = signup.getTextColors();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new signin_fragment()).commit();

        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentcontainer,new signUp_fragment()).commit();
                main_button.setText("Create Account");
                signin.setTextColor(csl);
                signup.setTextColor(Color.WHITE);
                int size = signup.getWidth();
                select.animate().x(size).setDuration(100);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentcontainer,new signin_fragment()).commit();
                main_button.setText("Signin");
                select.animate().x(0).setDuration(100);
                signin.setTextColor(Color.WHITE);
                signup.setTextColor(csl);
            }
        });


    }
}