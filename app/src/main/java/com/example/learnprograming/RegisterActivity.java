package com.example.learnprograming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private final String TAG="RegisterActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        TextInputEditText emailInput=findViewById(R.id.register_email);
        TextInputEditText passwordInput=findViewById(R.id.register_password);

        Button loginButton=findViewById(R.id.register_button);
        loginButton.setOnClickListener( view -> {

            String email=emailInput.getText().toString();
            String password=passwordInput.getText().toString();

            if(email.equals("")||equals(null)){
                Toast.makeText(RegisterActivity.this, "Please fill the Email input",
                        Toast.LENGTH_SHORT).show();
            }else if(password.equals("")||equals(null)){
                Toast.makeText(RegisterActivity.this, "Please fill the Password input",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Register success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success register");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent contentIntent = new Intent(RegisterActivity.this, LogInActivity.class);
                        startActivity(contentIntent);
                        Toast.makeText(RegisterActivity.this, "Registered Successfully",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        // If register in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterActivity.this, "This account already exists!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            // To Do: change the UI
//            Intent contentIntent = new Intent(RegisterActivity.this, LogInActivity.class);
//            startActivity(contentIntent);
        }
    }
}