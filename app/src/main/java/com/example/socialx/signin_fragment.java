package com.example.socialx;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class signin_fragment extends Fragment {

    View view;
    ColorStateList csl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_signin_fragment, container, false);

        FacebookSdk.sdkInitialize(requireActivity().getApplicationContext());
        csl = ((MainActivity)requireActivity()).signup.getTextColors();

        EditText em = view.findViewById(R.id.signin_name);
        EditText ps = view.findViewById(R.id.signin_password);

        Button signIn = ((MainActivity) requireActivity()).main_button;
        SignInButton google_signin = view.findViewById(R.id.google_signButton);
        LoginButton fb_button = view.findViewById(R.id.login_button);

        TextView register = view.findViewById(R.id.register);
        register.setOnClickListener(view1 -> {

            ((MainActivity)requireActivity()).main_button.setText("Create Account");
            ((MainActivity)requireActivity()).signup.setTextColor(Color.WHITE);
            ((MainActivity)requireActivity()).signin.setTextColor(csl);
            int size = ((MainActivity)requireActivity()).signup.getWidth();
            ((MainActivity)requireActivity()).select.animate().x(size).setDuration(100);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentcontainer,new signUp_fragment()).commit();
        });

        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("users");

        fb_button.setOnClickListener(view -> {
            Intent intent = new Intent(requireActivity(), facebookAuth.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

        signIn.setOnClickListener(view1 -> {

            String name = em.getText().toString();
            String password = ps.getText().toString();

            if (name.isEmpty()) {
                em.setError("This field can't be empty");
            } else if (password.isEmpty()) {
                ps.setError("This field can't be empty");
            } else {
                DatabaseReference check = firebaseDatabase.child(name);
                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        if (snapshot.exists()) {

                            String ps1 = snapshot.child("password").getValue(String.class);
                            if (ps1 != null && ps1.equalsIgnoreCase(password)) {
                                Intent intent = new Intent(getActivity(), home_activity.class);
                                startActivity(intent);
                                requireActivity().finish();
                            } else {
                                Toast.makeText(view1.getContext(), "Incorrect password", Toast.LENGTH_LONG).show();
                            }
                        } else {

                            Toast.makeText(view1.getContext(), "No such user exists", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });
            }
        });

        google_signin.setOnClickListener(view -> {
            Intent intent = new Intent(requireActivity(), googleAuth.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            requireActivity().finish();
        });
        return view;
    }
}
