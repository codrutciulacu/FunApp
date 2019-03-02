package com.codrut.funapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codrut.funapp.adapter.StandUpListAdapter;
import com.codrut.funapp.model.StandUp;

import java.util.ArrayList;
import java.util.List;

public class StandUpListActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY = "videoLink";
    public static final String TITLE_BUNDLE_KEY = "title";
    public static final String AUTHOR_BUNDLE_KEY = "author";

    private RecyclerView mStandUpRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
    }

    private void init() {
        mStandUpRecyclerView = findViewById(R.id.recycler_view_stand_up_list);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mStandUpRecyclerView.setLayoutManager(manager);

        StandUpListAdapter adapter = new StandUpListAdapter(this, getData());
        mStandUpRecyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mStandUpRecyclerView.getContext(),
                ((LinearLayoutManager) manager).getOrientation());
        mStandUpRecyclerView.addItemDecoration(dividerItemDecoration);

    }

    private List<StandUp> getData() {
        List<StandUp> standUps = new ArrayList<>();

        standUps.add(new StandUp("Frici | Sala Palatului", "Costel",
                "PHq0DC4qirQ", "https://i.ytimg.com/vi" +
                "/ffQ09U31vyE/maxresdefault.jpg"));

        standUps.add(new StandUp("Adolescentul", "Mane Voicu",
                "xpXvfqD8g7k", "https://i.ytimg.com/vi" +
                "/517TEVmerA4/hqdefault.jpg"));

        standUps.add(new StandUp("In spatele sotiei | Sala Palatului",
                "Costel", "z54ofMuP43g", "https://i.ytimg.com/vi" +
                "/ffQ09U31vyE/maxresdefault.jpg"));

        standUps.add(new StandUp("Mincu | Logan | Miopie | Kaufland",
                "Mincu Popovici", "3B2V17BfVhQ", "https://viitorulromaniei" +
                ".ro/wp-content/uploads/2018/02" +
                "/119698_8470744406239196524955421732979187513063274256306806130155618289.jpg"));

        standUps.add(new StandUp("Maria Popovici (Brasov " +
                "2017)", "Maria Popovici", "A5et66hFwRo", "https://viitorulromaniei" +
                ".ro/wp-content/uploads/2018/02" +
                "/119698_8470744406239196524955421732979187513063274256306806130155618289.jpg"));

        return standUps;
    }

}
