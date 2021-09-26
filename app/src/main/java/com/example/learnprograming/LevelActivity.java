package com.example.learnprograming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnprograming.adapters.RecyclerAdapter;

public class LevelActivity extends AppCompatActivity {
    private final String TAG = "LevelActivity";

    Button btnBegineer,btnIntermediate,btnExpert;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    String LevelSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

            btnBegineer=findViewById(R.id.btnBeginner);
            btnIntermediate=findViewById(R.id.btnIntermediate);
            btnExpert=findViewById(R.id.btnExpert);

        FillIntentData();


        btnBegineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btn Clicked inside: ");

                final Intent intent;
                Log.d(TAG, "Level GET: "+ LevelSelection);
                intent =  new Intent(getApplicationContext(), ExpandableLangDetailsActivity.class);
                intent.putExtra("Key",LevelSelection+"Begineer");
                startActivity(intent);
            }
        });
        btnIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btn Clicked inside: ");

                final Intent intent;
                Log.d(TAG, "Level GET: "+ LevelSelection);
                intent =  new Intent(getApplicationContext(), ExpandableLangDetailsActivity.class);
                intent.putExtra("Key",LevelSelection+"Intermediate");
                startActivity(intent);
            }
        });
        btnExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btn Clicked inside: ");

                final Intent intent;
                Log.d(TAG, "Level GET: "+ LevelSelection);
                intent =  new Intent(getApplicationContext(), ExpandableLangDetailsActivity.class);
                intent.putExtra("Key",LevelSelection+"Expert");
                startActivity(intent);
            }
        });

        Log.d(TAG, "btn Clicked: ");
//        listener=new RecyclerAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//
//            }
//        };



    }

    private void FillIntentData() {
        Intent intentLevel = getIntent();
        if(intentLevel!=null){
            LevelSelection =intentLevel.getStringExtra("LevelKey");
            Log.d(TAG, "inside intent : " + LevelSelection);
        }
        else {
            Log.d(TAG, "outside intent : " + LevelSelection);
        }
    }

}