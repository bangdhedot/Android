package com.example.mymonitoring;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;

public class CameraActivity extends AppCompatActivity implements MediaPlayer.EventListener {

    private static final String url = "rtsp://heri:heri1234@103.49.239.207:1012/cam/realmonitor?channel=1&subtype=1";

    private LibVLC libVlc;
    private MediaPlayer mediaPlayer;
    private VLCVideoLayout videoLayout;

    private ProgressDialog progressDialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ImageView BackButton = findViewById(R.id.Back);

        libVlc = new LibVLC(this);
        mediaPlayer = new MediaPlayer(libVlc);
        mediaPlayer.setEventListener(this);
        videoLayout = findViewById(R.id.videoLayout);
        progressDialog = new ProgressDialog(this);



        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void onEvent(MediaPlayer.Event event)
    {
        if (event.type == MediaPlayer.Event.Buffering) {
            if (event.getBuffering() == 100f) {
                progressDialog.hide();
            } else {
                progressDialog.show();
            }
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        mediaPlayer.attachViews(videoLayout, null, false, false);

        Media media = new Media(libVlc, Uri.parse(url));
        media.setHWDecoderEnabled(true, false);
        media.addOption(":network-caching=600");

        mediaPlayer.setMedia(media);
        media.release();
        mediaPlayer.play();
    }

    @Override
    protected void onStop()
    {
        super.onStop();

        mediaPlayer.stop();
        mediaPlayer.detachViews();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        mediaPlayer.release();
        libVlc.release();
    }
}