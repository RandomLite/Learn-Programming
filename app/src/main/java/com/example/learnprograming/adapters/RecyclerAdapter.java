package com.example.learnprograming.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.learnprograming.R;
import com.example.learnprograming.viewModels.MainLanguagesModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static  final String Tag="RecyclerView";
    private Context mContext;
    private ArrayList<MainLanguagesModel> mainLanguages_listArrayModel;
    //-----
    private RecyclerViewClickListener listener;

    public RecyclerAdapter(Context mContext, ArrayList<MainLanguagesModel> mainLanguages_listArrayModel, RecyclerViewClickListener listener) {
        this.mContext = mContext;
        this.mainLanguages_listArrayModel = mainLanguages_listArrayModel;
        this.listener=listener;//--
    }



    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.language_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //TextView
holder.textView.setText(mainLanguages_listArrayModel.get(position).getName());

//ImageView: Glide Library
        Glide.with(mContext)
                .load(mainLanguages_listArrayModel.get(position).getImgURL())
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mainLanguages_listArrayModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //Widgets:
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.language_img_url);
            textView=itemView.findViewById(R.id.language_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {//--
listener.onClick(itemView,getAdapterPosition());//--
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
//    public interface OnNoteListener{
//        void OnNoteListener(int position);
//    }
}
