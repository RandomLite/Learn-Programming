package com.example.learnprograming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.adapters.RecyclerAdapter;
import com.example.learnprograming.viewModels.MainLanguagesModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProgrammingLangActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerViewClickListener {

    private final String TAG = "ProgrammingLangActivity";

    RecyclerView recyclerView;
    FirebaseAuth fAuth;

    DatabaseReference myRef;
    private ArrayList<MainLanguagesModel> languagesListArrayList;
    private RecyclerAdapter recyclerAdapter;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_lang);

        fAuth = FirebaseAuth.getInstance();
//        UserId = fAuth.getCurrentUser().getUid();// Ketu osht tu bo problem shkaku i firebase expired mbas 30 diteve
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        myRef= FirebaseDatabase.getInstance().getReference();
//        ClearAll();
        GetDataFromFirebase();

    }

    private void GetDataFromFirebase() {
        Intent intent = getIntent();
        String TitlesOfLanguage=intent.getStringExtra("Key");
        Log.d(TAG, "Stringu TitlesOfLanguage :" +TitlesOfLanguage + " Key: " + intent.getStringExtra("Key") );

        Query query=myRef.child(TitlesOfLanguage);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    MainLanguagesModel languageslist=new MainLanguagesModel();

                    languageslist.setImgURL(snapshot.child("imgURL").getValue().toString());
                    languageslist.setName(snapshot.child("name").getValue().toString());

                    languagesListArrayList.add(languageslist);
                }
                recyclerAdapter=new RecyclerAdapter(getApplicationContext(),languagesListArrayList,listener);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        setOnClickListenerMeth();
    }
    String Level;
    Intent intentLevel= null;
    private void setOnClickListenerMeth() {

//        Query query=myRef.child("Java");



        listener=new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
//                Log.d(TAG, "Ketu e kemi ate qe vjen nga string:" + position);
//
//                QuizDialogFrag quizDialogFrag=new QuizDialogFrag();
//                quizDialogFrag.show(((FragmentActivity)v.getContext()).getSupportFragmentManager(),"MyFragment");


                final Intent intentLevel;
                switch (position){
                    case 0:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");
                        break;
                    case 1:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");
                        break;
                    case 2:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Python");
                        break;
                    case 3:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");
                        break;
                    case 4:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");
                        break;
                    case 5:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");
                        break;
                    case 6:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");

                        break;
                    case 7:
                        intentLevel =  new Intent(getApplicationContext(), LevelActivity.class);
                        intentLevel.putExtra("LevelKey","Java");
                        break;
                    default:
                        intentLevel =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        break;
                }
                startActivity(intentLevel);
            }
        };
    }


    private void ClearAll(){
        if(languagesListArrayList!=null){
            languagesListArrayList.clear();
            if (recyclerAdapter!=null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }

        languagesListArrayList=new ArrayList<>();

    }


    @Override
    public void onClick(View v, int position) {
        Log.d(TAG, "Ketu e kemi ate qe vjen nga stringuuu:" + position);
    }
}