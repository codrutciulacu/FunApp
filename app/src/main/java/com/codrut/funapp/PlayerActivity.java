package com.codrut.funapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayerActivity extends YouTubeBaseActivity {

    public static final String YOUTUBE_KEY = "AIzaSyBEnOmxPhUdPBK3C31HU4AavFP9i8pvm3Y";

    private YouTubePlayerView mYouTubePlayer;
    private TextView mTitleTextView;
    private TextView mAuthorTextView;
    private RatingBar mRatingBarForVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mYouTubePlayer = findViewById(R.id.youtube_player_view);
        mTitleTextView = findViewById(R.id.playerTitle);
        mAuthorTextView = findViewById(R.id.textViewAuthor);

        final Bundle bundle = getIntent().getExtras();

        mYouTubePlayer.initialize(YOUTUBE_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    if (bundle != null) {
                        String link = bundle.getString(StandUpListActivity.BUNDLE_KEY);
                        String title = bundle.getString(StandUpListActivity.TITLE_BUNDLE_KEY);
                        String author = bundle.getString(StandUpListActivity.AUTHOR_BUNDLE_KEY);

                        mTitleTextView.setText(title);
                        mAuthorTextView.setText(author);

                        youTubePlayer.cueVideo(link);
                    }
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(PlayerActivity.this, "The video you're trying to view is " +
                        "unavailable!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void shareOnClick(View view) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        final Bundle bundle = getIntent().getExtras();

        String link = bundle.getString(StandUpListActivity.BUNDLE_KEY);

        share.putExtra(Intent.EXTRA_SUBJECT, "Title of the stand-up");
        share.putExtra(Intent.EXTRA_TEXT, link);

        startActivity(Intent.createChooser(share, "Share StandUp To your friends!"));
    }
}
