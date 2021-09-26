package com.example.learnprograming.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.R;
import com.example.learnprograming.viewModels.MainLanguagesModel;


public class LanguageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView languageNameTextView;
    public ImageView languageImgTextView;

//    private ItemClickListener itemClickListener;

    public LanguageViewHolder(@NonNull View itemView) {
        super(itemView);

        languageImgTextView=itemView.findViewById(R.id.language_img_url);//duplicate command Ctrl+D
        languageNameTextView=itemView.findViewById(R.id.language_name);

    }

    public void bindData(MainLanguagesModel language){
//        languageImgTextView.setImageResource(language.getImgURL(https://firebasestorage.googleapis.com/v0/b/learnprograming-e188d.appspot.com/o/Mercedes-Benz-S-Class-2021-800-0a.jpg?alt=media&token=af770cd2-9156-418d-8ad9-5a0b1dd68852);
        languageNameTextView.setText(language.getName());


    }

    @Override
    public void onClick(View v) {

    }
}
