package com.example.socialx;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class signUp_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up_fragment, container, false);

        EditText name = view.findViewById(R.id.name);
        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);
        EditText number = view.findViewById(R.id.phone_number);

        Button signup = ((MainActivity)requireActivity()).main_button;

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("users");

                String nn = name.getText().toString();
                String em = email.getText().toString();
                String pp = password.getText().toString();
                String nm = number.getText().toString();

                if(nn.isEmpty()){
                    name.setError("This field can't be empty");
                }else if(em.isEmpty()){
                    email.setError("This field can't be empty");
                }else if(pp.isEmpty()){
                    password.setError("This field can't be empty");
                }else if(nm.isEmpty()){
                    number.setError("This field can't be empty");
                }else {
                    users user = new users(nn, em, pp, nm);
                    DatabaseReference check = firebaseDatabase.child(nn);
                    check.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.exists()) {
                                Toast.makeText(view.getContext(), "User already exists", Toast.LENGTH_LONG).show();
                            } else {
                                check.setValue(user);

                                Toast.makeText(view.getContext(), "Account created", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                                requireActivity().finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        return view;
    }
}