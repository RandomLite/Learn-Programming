package com.example.learnprograming.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.R;
import com.example.learnprograming.viewHolders.LanguageViewHolder;
import com.example.learnprograming.viewModels.MainLanguagesModel;

import java.util.ArrayList;
import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageViewHolder> {

private Context mContext;
private List<MainLanguagesModel> mLanguage_list;
    private List<MainLanguagesModel> languages=new ArrayList<>();

public LanguageAdapter(Context context,List<MainLanguagesModel> mainLanguages_models){
    mContext=context;
    mLanguage_list= mainLanguages_models;
}

    public LanguageAdapter(RecyclerView recyclerView) {
    }
//    public void setLanguages(List<Languages_List> languages){
//        this.languages.clear();
//        this.languages.addAll(languages);// (this)osht e definume per qet field
//        notifyDataSetChanged();
//    }



    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.language_item, parent,false);
        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {
        holder.languageNameTextView.setText(languages.get(position).getName());
        holder.bindData(this.languages.get(position));

        //ImageView: Glide Library:
//        Glide.with(mContext)
//                .load(mLanguage_list.get(position).getImgURL())
//                .into(holder.languageImgTextView);
    }

    @Override
    public int getItemCount() {
        return this.languages.size();
    }
}
