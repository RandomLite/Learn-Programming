package com.example.learnprograming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.learnprograming.viewModels.Question_Answer_Model;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Quiz#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quiz extends Fragment {
    final String TAG="Quiz";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<Question_Answer_Model> question_answer_modelArrayList;
    LanguageDetails languageDetails=new LanguageDetails();

    

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public String myString;
    private TextView textView;
    private Button btnBgn,btnItm,btnExp;
//    Context mContext;

    public Quiz() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Quiz.
     */
    // TODO: Rename and change types and number of parameters
    public static Quiz newInstance(String param1, String param2) {
        Quiz fragment = new Quiz();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        btnBgn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), MobileAppDevActivity.class);
//                startActivity(intent);
//                Log.d(TAG, "onClick: Klikuar");
//            }
//        });
//
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_quiz, container, false);
//        textView= view.findViewById(R.id.quizQuestion);
        QuizDialogFrag quizDialogFrag= new QuizDialogFrag();
        btnBgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


//        Bundle data=getArguments();
//        Log.d(TAG, "data osht: " + data);
//        if(data!= null){
//            myString=data.getString("Celesi");
//        }
//        Log.d(TAG,"Success"+" :: "+ myString);
//
//        textView.setText(myString);
//


        return view;

    }
}