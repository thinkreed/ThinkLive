package com.reed.live.presentations.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.reed.thinklive.R;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FOR_READ_EXTERNAL_STORAGE = 0;
    private static final int REQUEST_CODE_FOR_CAMERA = 1;
    private static final int REQUEST_CODE_FOR_FLASH_LIGHT = 2;
    private static final int REQUEST_CODE_FOR_WRITE_EXTERNAL_STORAGE = 3;
    private static final int REQUEST_CODE_FOR_RECORD_AUDIO = 4;
    private static final int REQUEST_CODE_FOR_MODIFY_AUDIO_SETTINGS = 5;
    private static final int REQUEST_CODE_FOR_WAKE_LOCK = 6;
    private static final int REQUEST_CODE_FOR_MODIFY_INTERNET = 7;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        checkApiVersionAndPermission();

        View btn_jump = findViewById(R.id.button_jump);
        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiveActivity.class);
                startActivity(intent);
            }
        });

        View btn_player = findViewById(R.id.button_player);
        btn_player.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkApiVersionAndPermission() {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        if (currentVersion >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
                    REQUEST_CODE_FOR_READ_EXTERNAL_STORAGE);
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.MODIFY_AUDIO_SETTINGS)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.MODIFY_AUDIO_SETTINGS },
                    REQUEST_CODE_FOR_MODIFY_AUDIO_SETTINGS);
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA },
                    REQUEST_CODE_FOR_CAMERA);
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.RECORD_AUDIO },
                    REQUEST_CODE_FOR_RECORD_AUDIO);
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE },
                    REQUEST_CODE_FOR_WRITE_EXTERNAL_STORAGE);
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.WAKE_LOCK }, REQUEST_CODE_FOR_WAKE_LOCK);
            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.INTERNET },
                    REQUEST_CODE_FOR_MODIFY_INTERNET);
            }
        }
    }

    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_FOR_READ_EXTERNAL_STORAGE:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_CAMERA:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_WAKE_LOCK:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_FLASH_LIGHT:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_RECORD_AUDIO:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_MODIFY_AUDIO_SETTINGS:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            case REQUEST_CODE_FOR_MODIFY_INTERNET:
                if (grantResults.length <= 0
                    || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // TODO: 16/5/26 not decide yet....request again or close the application
                }
                break;
            default:
                break;
        }
    }
}
