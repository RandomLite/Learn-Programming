package com.example.learnprograming;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.adapters.ExpandableLangDetailsAdapter;
import com.example.learnprograming.viewModels.ExpandableLangDetails_Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//QuestionDialogFragment.SingleChoiseListener,ExpandableLangDetailsAdapter.DialogOnCickListener
public class ExpandableLangDetailsActivity extends AppCompatActivity  {

    private static final String TAG = "ExpandableLangDetailsActivity";
    public String quest1;
    DatabaseReference myRef;
    private ExpandableLangDetailsAdapter expandableLangDetailsAdapter;
    private ExpandableLangDetailsAdapter.DialogOnClickListener listener;
    private ExpandableLangDetailsAdapter.DialogOnClickListener mListener;
    RecyclerView recyclerView;
    List<ExpandableLangDetails_Model> expandableLangDetails_modelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_lang_details);

        myRef= FirebaseDatabase.getInstance().getReference();
        recyclerView=findViewById(R.id.recycler_view_expandableLangDetails);

        initData();
    }

//    private void setRecyclerView() {
//        ExpandableLangDetailsAdapter expandableLangDetailsAdapter=new ExpandableLangDetailsAdapter(expandableLangDetails_modelList);
//        recyclerView.setAdapter(expandableLangDetailsAdapter);
//        recyclerView.setHasFixedSize(true);
//    }

    @SuppressLint("LongLogTag")
    private void initData() {
        Intent intent = getIntent();
//        Bundle bundle = getIntent().getExtras();
        String TitlesOfLessons=intent.getStringExtra("Key");

        Log.d(TAG, "Stringu :" +TitlesOfLessons + " Key: " + intent.getStringExtra("Key") );

        Query query=myRef.child(TitlesOfLessons);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final Intent intent = new Intent();

                ClearAll();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {

                    ExpandableLangDetails_Model expandableLangDetails_model = new ExpandableLangDetails_Model();

                    expandableLangDetails_model.setTitle(snapshot.child("title").getValue().toString());
                    expandableLangDetails_model.setDescription(snapshot.child("description").getValue().toString());

                    expandableLangDetails_modelList.add(expandableLangDetails_model);
                }

                ExpandableLangDetailsAdapter expandableLangDetailsAdapter=new ExpandableLangDetailsAdapter(getApplicationContext(),expandableLangDetails_modelList,listener);
                recyclerView.setAdapter(expandableLangDetailsAdapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ClearAll(){
        if(expandableLangDetails_modelList!=null){
            expandableLangDetails_modelList.clear();
            if (expandableLangDetailsAdapter!=null){
                expandableLangDetailsAdapter.notifyDataSetChanged();
            }
        }
        expandableLangDetails_modelList=new ArrayList<>();
    }
}