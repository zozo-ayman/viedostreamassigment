package com.example.ass4mcc;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class VideoDisplayActivity extends AppCompatActivity {


    PlayerView playerView;
    SimpleExoPlayer player;
    String videoUrl;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_display);
        playerView = findViewById(R.id.video_display);
        videoUrl = getIntent().getStringExtra("Url");

    }

    public void initVideo() {
        // player
        player = ExoPlayerFactory.newSimpleInstance(this);

        // connect player with playerview
        playerView.setPlayer(player);

        // media source
        Uri uri = Uri.parse(videoUrl);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "exoplayer-codelab");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(mediaSource, false, false);

    }


    public void releaseVideo() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;

        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }


    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }



    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }
}
