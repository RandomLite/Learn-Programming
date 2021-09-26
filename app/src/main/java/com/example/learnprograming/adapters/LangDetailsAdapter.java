package com.example.learnprograming.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnprograming.R;
import com.example.learnprograming.viewModels.LangDetails;

import java.util.ArrayList;

public class LangDetailsAdapter extends RecyclerView.Adapter<LangDetailsAdapter.ViewHolder> {
    private static  final String Tag="LangDetailsAdapter";
    private Context mContext;

    private ArrayList<LangDetails> langDetailsArrayList;
    //-----
    private RecyclerViewClickListener listenerDetails;

    public LangDetailsAdapter(Context mContext, ArrayList<LangDetails> langDetailsArrayList, RecyclerViewClickListener listenerDetails) {
        this.mContext = mContext;
        this.langDetailsArrayList = langDetailsArrayList;
        this.listenerDetails=listenerDetails;//--
    }

    @NonNull
    @Override
    public LangDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.language_details_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.button.setText(langDetailsArrayList.get(position).getTitle());
        holder.textView.setText(langDetailsArrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return langDetailsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
//        ImageView imageView;
        TextView textView;
        Button button;
//        ExpandableListView expandableListView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            imageView = itemView.findViewById(R.id.language_img_url);
            textView =(TextView) itemView.findViewById(R.id.title_langDetails);
            button=(Button) itemView.findViewById(R.id.btn_Expand);
            button.setOnClickListener(this);
            textView.setOnClickListener(this);
//            expandableListView=itemView.findViewById(R.id.expandable_layout);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {//--
//            textView=v.findViewById(R.id.title_langDetails);
//            listenerDetails.onClick(textView, getAdapterPosition());
            listenerDetails.onClick(button,getAdapterPosition());
        }
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

//    private static final int UNSELECTED = -1;
//
//    private RecyclerView recyclerView;
//    private int selectedItem = UNSELECTED;
//
//    public LangDetailsAdapter(RecyclerView recyclerView) {
//        this.recyclerView = recyclerView;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.activity_language_details, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.bind();
//    }
//
//    @Override
//    public int getItemCount() {
//        return 100;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
//        private ExpandableLayout expandableLayout;
//        private TextView expandButton;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            expandableLayout = itemView.findViewById(R.id.expandable_layout);
//            expandableLayout.setInterpolator(new OvershootInterpolator());
//            expandableLayout.setOnExpansionUpdateListener(this);
//            expandButton = itemView.findViewById(R.id.expandable_layout);
//
//            expandButton.setOnClickListener(this);
//        }
//
//        public void bind() {
//            int position = getAdapterPosition();
//            boolean isSelected = position == selectedItem;
//
//            expandButton.setText(position + ". Tap to expand");
//            expandButton.setSelected(isSelected);
//            expandableLayout.setExpanded(isSelected, false);
//        }
//
//        @Override
//        public void onClick(View view) {
//            ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
//            if (holder != null) {
//                holder.expandButton.setSelected(false);
//                holder.expandableLayout.collapse();
//            }
//
//            int position = getAdapterPosition();
//            if (position == selectedItem) {
//                selectedItem = UNSELECTED;
//            } else {
//                expandButton.setSelected(true);
//                expandableLayout.expand();
//                selectedItem = position;
//            }
//        }
//
//        @Override
//        public void onExpansionUpdate(float expansionFraction, int state) {
//            Log.d("ExpandableLayout", "State: " + state);
//            if (state == ExpandableLayout.State.EXPANDING) {
//                recyclerView.smoothScrollToPosition(getAdapterPosition());
//            }
//        }
//    }
}

/**
package com.example.learnprograming;

        import android.content.Context;
        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.learnprograming.adapters.LangDetailsAdapter;
        import com.example.learnprograming.viewModels.LangDetails;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.storage.FirebaseStorage;

        import java.util.ArrayList;

//import com.example.learnprograming.adapters.LangDetailsAdapter;
//import com.example.learnprograming.adapters.LanguageAdapter;

public class LanguageDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef;
    //    List<Languages_List> languages_list = new ArrayList<>();
    private ArrayList<LangDetails> languagesListArrayList;
    private LangDetailsAdapter langDetailsAdapter;
    private Context mContext;
    private RecyclerView.LayoutManager layoutManager;
    //    private LangDetailsAdapter.RecyclerViewClickListener listener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_details);

        recyclerView=findViewById(R.id.recyclerview_langDetail);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef=FirebaseDatabase.getInstance().getReference();


    }
}
*/