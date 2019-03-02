package com.codrut.funapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.codrut.funapp.StandUpListActivity;
import com.codrut.funapp.PlayerActivity;
import com.codrut.funapp.R;
import com.codrut.funapp.model.StandUp;
import com.codrut.funapp.viewholder.StandUpListViewHolder;

import java.util.List;

public class StandUpListAdapter extends RecyclerView.Adapter<StandUpListViewHolder> {

    private List<StandUp> mStandUps;
    private Context mContext;

    public StandUpListAdapter(Context context, List<StandUp> standUps) {
        mStandUps = standUps;
        mContext = context;
    }

    @NonNull
    @Override
    public StandUpListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup
                        , false);

        return new StandUpListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StandUpListViewHolder listViewHolder, int i) {
        final StandUp currentStandUp = mStandUps.get(i);

        listViewHolder.getTitleTextView().setText(currentStandUp.getName());
        listViewHolder.getAuthorTextView().setText(currentStandUp.getAuthor());

        RequestOptions options = new RequestOptions()
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .dontTransform();

        Glide.with(mContext).load(currentStandUp.getThumbnailURL())
                .apply(options)
                .into(listViewHolder.getThumbnailImageView());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayerActivity.class);
                intent.putExtra(StandUpListActivity.BUNDLE_KEY, currentStandUp.getStandUpURL());
                intent.putExtra(StandUpListActivity.TITLE_BUNDLE_KEY, currentStandUp.getName());
                intent.putExtra(StandUpListActivity.AUTHOR_BUNDLE_KEY, currentStandUp.getAuthor());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStandUps.size();
    }
}
