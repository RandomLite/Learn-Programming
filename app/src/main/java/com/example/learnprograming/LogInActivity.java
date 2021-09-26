package com.example.learnprograming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    private final String TAG="LogInActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        TextInputEditText emailInput=findViewById(R.id.email);
        TextInputEditText passwordInput=findViewById(R.id.password);

        Button loginButton=findViewById(R.id.login_button);
        loginButton.setOnClickListener( view -> {

            String email=emailInput.getText().toString();
            String password=passwordInput.getText().toString();

            if(email.equals("")||equals(null)){
                Toast.makeText(LogInActivity.this, "Please fill the Email input",
                        Toast.LENGTH_SHORT).show();
            }else if(password.equals("")||equals(null)){
                Toast.makeText(LogInActivity.this, "Please fill the Password input",
                        Toast.LENGTH_SHORT).show();
            }
          else{
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {

                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent contentIntent=new Intent(LogInActivity.this, ContentActivity.class);
                        startActivity(contentIntent);
                        Toast.makeText(LogInActivity.this, "Welcome to Learn Programming",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(LogInActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

        TextView registerText=findViewById(R.id.go_register);
        registerText.setOnClickListener(view->{
            Intent contentIntent=new Intent(LogInActivity.this, RegisterActivity.class);
            startActivity(contentIntent);

        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            // To Do: change the UI
//            Intent contentIntent=new Intent(LogInActivity.this, ContentActivity.class);
//            startActivity(contentIntent);
        }
    }
}