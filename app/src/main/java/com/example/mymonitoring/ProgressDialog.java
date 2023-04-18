package com.example.mymonitoring;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class ProgressDialog {

    private static final int delayMs = 1000;
    private boolean isVisible = false;
    private long startTime = 0;
    private final Dialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProgressDialog(Context context)
    {
        dialog = new AlertDialog.Builder(context)
                .setView(R.layout.buffering)
                .setCancelable(false)
                .create();
    }

    public void show()
    {
        if (isVisible) {
            return;
        }
        if (startTime == 0L) {
            startTime = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - startTime > delayMs) {
            isVisible = true;
            dialog.show();
        }
    }

    public void hide()
    {
        startTime = 0;
        isVisible = false;
        dialog.hide();
    }
}
