package com.example.learnprograming;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class QuestionDialogFragment extends DialogFragment{
final String TAG= "QuestionDialogFragment";

    int position=0;

    String[] itemsArray;
    public interface SingleChoiseListener{
        void onPositiveButtonClicked(String list,int position);
        void onNegativeButtonClicked();
    }
    SingleChoiseListener mListener;

    String myString;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        Bundle data=getArguments();
        if(data!= null){
        myString=data.getString("Celesi");
        }
        Log.d(TAG,"Success"+" :: "+ myString);

       String correctAnswer="System.out.println()";
        String[] list = getActivity().getResources().getStringArray(R.array.choise_items);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        ExpandableLangDetailsActivity expandableLangDetailsActivity=new ExpandableLangDetailsActivity();
        builder.setTitle("Which method prints text in a Java program?:")
                .setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position = which;
                    }
                });

        builder.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                            mListener.onPositiveButtonClicked(list[position],position);
                if (list[position].equals(correctAnswer)) {
                    Toast.makeText(getActivity(), "Correct Answer!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Incorrect Answer!",
                            Toast.LENGTH_SHORT).show();
                }
//                Log.d(TAG, "Success" + list[position] + " :: " + Quest1);

            }
        }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

//                            mListener.onNegativeButtonClicked();
                Log.d(TAG, "Close");
            }
        });


        return builder.create();

    }
    @Override
    public void onStart(){
        super.onStart();

        Log.d(TAG,"Success List"+" :: "+"Fillon"+" ::: "+" : onStart");

    }

}
