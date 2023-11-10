package com.example.imageselectordialog;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnImageSelect;
    private ImageView imgView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnImageSelect = findViewById(R.id.btnImageSelect);
        imgView = findViewById(R.id.imgView);

        btnImageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageSelectorDialog imageselectordialog = new ImageSelectorDialog(MainActivity.this);
                imageselectordialog.setSetImageListener(new MySetImageListener());
                imageselectordialog.show();
            }
        });
    }

    private class MySetImageListener implements ImageSelectorDialog.SetImageListener{

        @Override
        public void setImage(Integer image, ImageSelectorDialog imageSelectorDialog) {
            imageSelectorDialog.dismiss();
            imgView.setImageResource(image);
        }
    }
}
