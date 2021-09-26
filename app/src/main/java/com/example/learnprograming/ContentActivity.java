package com.example.learnprograming;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;


public class ContentActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerViewClickListener {



    private final String TAG = "ContentActivity";

    TextView _name;
    ImageView language_image;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth fAuth;
    String UserId;
    //----
    RecyclerView recyclerView;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef;
    private ArrayList<MainLanguagesModel> languagesListArrayList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//-----
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef=FirebaseDatabase.getInstance().getReference();

        //Clear ArrayList:
        ClearAll();

        //Get Data Method:
        GetDataFromFirebase();

    }

    private void GetDataFromFirebase() {

        Query query=myRef.child("AllLanguages");
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
//    String ContentActivityString;

    Intent intent= null;
    private void setOnClickListenerMeth() {

//        Query query=myRef.child("Java");


        listener=new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Log.d(TAG, "Ketu e kemi ate qe vjen nga string:" + position);

                final Intent intent;
                switch (position){
                    case 0:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","ProgrammingLang");
                        break;
                    case 1:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    case 2:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    case 3:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    case 4:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    case 5:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    case 6:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    case 7:
                        intent =  new Intent(getApplicationContext(), ProgrammingLangActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                    default:
                        intent =  new Intent(getApplicationContext(), ContentActivity.class);
                        intent.putExtra("Key","Mobile");
                        break;
                }
                startActivity(intent);
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
