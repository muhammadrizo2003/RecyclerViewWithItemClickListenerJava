package com.example.project10.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project10.activity.MainActivity;
import com.example.project10.R;
import com.example.project10.models.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final MainActivity mainActivity;
    private final ArrayList<Member> itemList;


    public CustomAdapter(MainActivity mainActivity, ArrayList<Member> itemList) {
        this.itemList = itemList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = itemList.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView txt_name = holder.itemView.findViewById(R.id.txt_name);
            TextView txt_surname = holder.itemView.findViewById(R.id.txt_surname);

            txt_name.setText(member.getName());
            txt_surname.setText(member.getSurname());
            LinearLayout linearLayout = holder.itemView.findViewById(R.id.layout_btn);

            linearLayout.setOnClickListener(view -> {
                // mainActivity = new MainActivity();
                mainActivity.showToast(member);
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private static final class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public TextView txt_name, txt_surname;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            txt_name = view.findViewById(R.id.txt_name);
            txt_surname = view.findViewById(R.id.txt_surname);
        }
    }
}
