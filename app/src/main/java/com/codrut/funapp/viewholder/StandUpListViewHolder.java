package com.codrut.funapp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codrut.funapp.R;

import org.w3c.dom.Text;

public class StandUpListViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleTextView;
    private TextView mAuthorTextView;
    private ImageView mThumbnailImageView;

    public StandUpListViewHolder(View itemView) {
        super(itemView);

        initView(itemView);
    }

    private void initView(View itemView) {
        mTitleTextView = itemView.findViewById(R.id.text_view_title);
        mAuthorTextView = itemView.findViewById(R.id.text_view_author);
        mThumbnailImageView = itemView.findViewById(R.id.image_view_thumbnail);
    }

    public TextView getTitleTextView() {
        return mTitleTextView;
    }

    public void setTitleTextView(TextView titleTextView) {
        mTitleTextView = titleTextView;
    }

    public TextView getAuthorTextView() {
        return mAuthorTextView;
    }

    public void setAuthorTextView(TextView authorTextView) {
        mAuthorTextView = authorTextView;
    }

    public ImageView getThumbnailImageView() {
        return mThumbnailImageView;
    }

    public void setThumbnailImageView(ImageView thumbnailImageView) {
        mThumbnailImageView = thumbnailImageView;
    }
}
