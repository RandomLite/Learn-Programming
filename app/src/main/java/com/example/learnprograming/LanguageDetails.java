package com.example.learnprograming;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.adapters.LangDetailsAdapter;
import com.example.learnprograming.viewModels.LangDetails;
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

public class LanguageDetails extends AppCompatActivity implements LangDetailsAdapter.RecyclerViewClickListener{


    public final String TAG = "LanguageDetails";

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth fAuth;
    String UserId;
    //----
    RecyclerView recyclerView;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef;
    //    List<Languages_List> languages_list = new ArrayList<>();
    public ArrayList<LangDetails> langDetailsArrayList;
    private LangDetailsAdapter langDetailsAdapter;
    private Context mContext;
    private RecyclerView.LayoutManager layoutManager;
    private LangDetailsAdapter.RecyclerViewClickListener listener;

    //-------------------
    private final static String LONG_TEXT = "Lorem ipsum dolor sit amet, et" +
            " alienum inciderint efficiantur nec, posse causae molestie" +
            " eos in. Ea vero praesent vix, nam soleat recusabo id." +
            " Qui ut exerci option laboramus. In habeo posse ridens quo," +
            " eligendi volutpat interesset ut est, mel nibh accusamus no." +
            " Te eam consulatu repudiare adipiscing, usu et choro quodsi euripidis.";

    private final static String SHORT_TEXT = " For the 2009 model " +
            "the G35 sedan was replaced by the G37 sedan.";

    private final static int MAX_LINES_COLLAPSED = 3;
    private final boolean INITIAL_IS_COLLAPSED = true;

    private boolean isCollapsed = INITIAL_IS_COLLAPSED;

//    private TextView[] detailsOfLanguages;
    private Button btnExpand;
    private ConstraintLayout mParentLayout;
    //--------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_details);
        recyclerView=findViewById(R.id.recycler_view_details);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //---------------------------------------------------------------
        mParentLayout = findViewById(R.id.root_container);
        btnExpand=findViewById(R.id.btn_Expand);

//        detailsOfLanguages = findViewById(R.id.title_langDetails);
//        for (int i=0;i<;i++){
//            detailsOfLanguages[i] = findViewById(R.id.title_langDetails);
//        }
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef=FirebaseDatabase.getInstance().getReference();


//        //Clear ArrayList:
//        ClearAll();

        //Get Data Method:
        GetDataFromFirebase();
//        setOnClickListenerMeth();




//        btnExpand.setOnClickListener(v -> {
//            if (isCollapsed) {
//                detailsOfLanguages.setMaxLines(Integer.MAX_VALUE);
//            } else {
//                detailsOfLanguages.setMaxLines(MAX_LINES_COLLAPSED);
//            }
//            isCollapsed = !isCollapsed;
//        });
//        detailsOfLanguages.setText(LONG_TEXT);
        //--------------------------------------
    }

    private void GetDataFromFirebase() {

        Query query=myRef.child("Mobile");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    LangDetails langDetailsList=new LangDetails();

//                    languageslist.setImgURL(snapshot.child("imgURL").getValue().toString());

                    langDetailsList.setTitle(snapshot.child("name").getValue().toString());
                    langDetailsList.setDescription(snapshot.child("description").getValue().toString());
//                    detailsOfLanguages.setText("");
                    langDetailsArrayList.add(langDetailsList);
                }
                langDetailsAdapter=new LangDetailsAdapter(getApplicationContext(),langDetailsArrayList,listener);
                recyclerView.setAdapter(langDetailsAdapter);
                langDetailsAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        setOnClickListenerMeth();

    }
int i=0;
    private void setOnClickListenerMeth() {

        listener = new LangDetailsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Log.d(TAG, "Ketu e kemi ate qe vjen nga string:" + position);
//                detailsOfLanguages=null;
                TextView[] detailsOfLanguages = new TextView[langDetailsArrayList.size()];
//                detailsOfLanguages[position] = findViewById(R.id.title_langDetails);


                for (i = 0; i < langDetailsArrayList.size(); i++) {

                    detailsOfLanguages[i] = findViewById(R.id.title_langDetails);
                    Log.d(TAG, "kontroll pozicioni: " + position + " i-ja: " + i + " array:" + langDetailsArrayList.size());
                    if (position == i) {

                        Log.d(TAG, "kontroll pozicioni osht : " + position + " i: " + i + " *");

                        if (isCollapsed) {
                            Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE + " TextView: " + detailsOfLanguages[position]);
                            detailsOfLanguages[i].setMaxLines(Integer.MAX_VALUE);
                            Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE + " TextView: " + detailsOfLanguages[position]);

                        } else {
                            Log.d(TAG, "Osht False te ELSE" + position + " ArrayLista:" + langDetailsArrayList.size());
                            detailsOfLanguages[i].setMaxLines(MAX_LINES_COLLAPSED);
                        }

                    }
                    isCollapsed = !isCollapsed;
                }
            }
////
////        switch (position){
////            case 0:
////                if (isCollapsed) {
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguages[position]);
////                    detailsOfLanguages[langDetailsArrayList.get(position).method()].setMaxLines(Integer.MAX_VALUE);
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguages[position]);
////
////                } else {
////                    Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
////                    detailsOfLanguages[position].setMaxLines(MAX_LINES_COLLAPSED);
////                }
////                isCollapsed = !isCollapsed;
////            case 1:
////                if (isCollapsed) {
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguages[position]);
////                    detailsOfLanguages[position].setMaxLines(Integer.MAX_VALUE);
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguages[position]);
////
////                } else {
////                    Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
////                    detailsOfLanguages[position].setMaxLines(MAX_LINES_COLLAPSED);
////                }
////                isCollapsed = !isCollapsed;
////            case 2:
////                if (isCollapsed) {
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguages[position]);
////                    detailsOfLanguages[position].setMaxLines(Integer.MAX_VALUE);
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguages[position]);
////
////                } else {
////                    Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
////                    detailsOfLanguages[position].setMaxLines(MAX_LINES_COLLAPSED);
////                }
////                isCollapsed = !isCollapsed;
////            case 3:
////                if (isCollapsed) {
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguages[position]);
////                    detailsOfLanguages[position].setMaxLines(Integer.MAX_VALUE);
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguages[position]);
////
////                } else {
////                    Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
////                    detailsOfLanguages[position].setMaxLines(MAX_LINES_COLLAPSED);
////                }
////                isCollapsed = !isCollapsed;
////            case 4:
////                if (isCollapsed) {
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguages[position]);
////                    detailsOfLanguages[position].setMaxLines(Integer.MAX_VALUE);
////                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguages[position]);
////
////                } else {
////                    Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
////                    detailsOfLanguages[position].setMaxLines(MAX_LINES_COLLAPSED);
////                }
////                isCollapsed = !isCollapsed;
////
////            break;
////            default:
////                throw new IllegalStateException("Unexpected value: " + position);
////        }//---++++ End OF Switch
////
//
//
//
////            if (isCollapsed) {
////                Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguages[position]);
////                detailsOfLanguages[position].setMaxLines(Integer.MAX_VALUE);
////                Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguages[position]);
////
////            } else {
////                Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
////                detailsOfLanguages[position].setMaxLines(MAX_LINES_COLLAPSED);
////            }
////            isCollapsed = !isCollapsed;
////                }
//
//
//
        };
    }



    private void ClearAll(){
        if(langDetailsArrayList!=null){
            langDetailsArrayList.clear();
            if (langDetailsAdapter!=null){
                langDetailsAdapter.notifyDataSetChanged();
            }
        }

        langDetailsArrayList=new ArrayList<>();

    }


    @Override
    public void onClick(View v, int position) {
//        Log.d(TAG, "Ketu e kemi ate qe vjen nga stringuuu:" + position);
//        TextView[] detailsOfLanguage = new TextView[langDetailsArrayList.size()];
//        for (i=0;i<langDetailsArrayList.size();i++) {
//
//            Log.d(TAG, "kontroll pozicioni: " + position + " i-ja: " +i+" array:"+langDetailsArrayList.size());
//                if (position==i){
//
//                    Log.d(TAG, "kontroll pozicioni osht : "+ position+ " i: " +i+" *");
//
//                if (isCollapsed) {
//                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE+" TextView: "+ detailsOfLanguage[position]);
//                    detailsOfLanguage[position].setMaxLines(Integer.MAX_VALUE);
//                    Log.d(TAG, "Osht True te IF" + position + " MaxValue " + Integer.MAX_VALUE +" TextView: "+ detailsOfLanguage[position]);
//
//                } else {
//                    Log.d(TAG, "Osht False te ELSE" + position+" ArrayLista:"+langDetailsArrayList.size());
//                    detailsOfLanguage[position].setMaxLines(MAX_LINES_COLLAPSED);
//                }
//
//                }
//            isCollapsed = !isCollapsed;
//        }
    }

}