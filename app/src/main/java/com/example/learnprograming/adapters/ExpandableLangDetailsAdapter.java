package com.example.learnprograming.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.QuestionDialogFragment;
import com.example.learnprograming.R;
import com.example.learnprograming.viewModels.ExpandableLangDetails_Model;

import java.util.List;

public class ExpandableLangDetailsAdapter extends RecyclerView.Adapter<ExpandableLangDetailsAdapter.ExpandableHolder> implements QuestionDialogFragment.SingleChoiseListener {

    private DialogOnClickListener listenerDialog;

    List<ExpandableLangDetails_Model> expandableLangDetails_modelList;
//    Dialog dialog;
Context mContext;

    public ExpandableLangDetailsAdapter(Context mContext,List<ExpandableLangDetails_Model> expandableLangDetails_modelList,DialogOnClickListener listenerDialog) {
        this.expandableLangDetails_modelList = expandableLangDetails_modelList;
        this.mContext=mContext;
        this.listenerDialog=listenerDialog;

    }

    @NonNull
    @Override
    public ExpandableHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_card_item,parent,false);
       return  new ExpandableHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpandableHolder holder, int position) {

        ExpandableLangDetails_Model expandableLangDetails_model=expandableLangDetails_modelList.get(position);
        holder.titleExpand.setText(expandableLangDetails_model.getTitle());
        holder.descriptionExpand.setText(expandableLangDetails_model.getDescription());

        boolean isExpandable=expandableLangDetails_modelList.get(position).isExpandable() ;
        holder.expandableRelLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        //---

//        holder.btnQuestion.setText(expandableLangDetails_modelList.get(position).getTitle());
          holder.btnQuestion.setText("Question");

    }

    @Override
    public int getItemCount() {
        return expandableLangDetails_modelList.size();
    }

    @Override
    public void onPositiveButtonClicked(String list, int position) {

    }

    @Override
    public void onNegativeButtonClicked() {

    }

    public class ExpandableHolder extends RecyclerView.ViewHolder {

        TextView titleExpand,descriptionExpand,mTextView;
        LinearLayout linearLayout;
        RelativeLayout expandableRelLayout;

        Button btnQuestion;//----



        public ExpandableHolder(@NonNull View itemView) {
            super(itemView);

            titleExpand=itemView.findViewById(R.id.title_expadableItem);
            descriptionExpand=itemView.findViewById(R.id.description_expandableItem);

            linearLayout=itemView.findViewById(R.id.linear_layout_expandableItem);
            expandableRelLayout=itemView.findViewById(R.id.relative_expandableItem);

            //-------
            btnQuestion=(Button) itemView.findViewById(R.id.btn_Quest);

            titleExpand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ExpandableLangDetails_Model expandableLangDetails_model=expandableLangDetails_modelList.get(getAdapterPosition());
                    expandableLangDetails_model.setExpandable(!expandableLangDetails_model.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            btnQuestion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){

                    DialogFragment singleChoiseDialog=new QuestionDialogFragment();//1
//                    String Question="Hello World";
//                    Bundle data =new Bundle();
//                    data.putString("Celesi",Question);

//                    singleChoiseDialog.setArguments(data);//1


           singleChoiseDialog.setCancelable(false);
            singleChoiseDialog.show(((FragmentActivity)itemView.getContext()).getSupportFragmentManager(), "Single Choise Dialog");

                    /**
                    quizDialogFrag.setArguments(data);
                    quizDialogFrag.show(((FragmentActivity)itemView.getContext()).getSupportFragmentManager(),"MyFragment");
                     */

                   // FragmentTransaction transaction = ((FragmentActivity)itemView.getContext()).getSupportFragmentManager().beginTransaction();


//                    String Question="Hello World";
//                    Bundle data =new Bundle();
//                    data.putString("Key",Question);
//                    quiz.setArguments(data);
//                    transaction.replace(R.id.expand_lang_question,quiz).commit();
//                 *///
                     }//getSupportFragmentManager()
            });

        }

        public void onClick(View itemView) {//--
            listenerDialog.onClick(btnQuestion,getAdapterPosition());//--
        }
    }

    public interface DialogOnClickListener{
        void onClick(View v, int position);
    }
}
