package com.example.project10.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project10.R;
import com.example.project10.adapters.CustomAdapter;
import com.example.project10.models.Member;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MainActivity context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        refreshAdapter(prepareMemberList());

    }

    void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //        SnapHelper snapHelper = new PagerSnapHelper();
        //        snapHelper.attachToRecyclerView(recyclerView);

    }

    void refreshAdapter(ArrayList<Member> members) {
        CustomAdapter customAdapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }

    ArrayList<Member> prepareMemberList() {
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 1; i <= 102; i++) {
            members.add(new Member("Muhammadrizo" + i, "Nurullaxo'jayev" + i));
        }
        return members;
    }

    public void showToast(Member member) {
        Toast.makeText(MainActivity.this, member.toString(), Toast.LENGTH_SHORT).show();
    }
}

