package com.example.imageprogect;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST = 1;

    private Uri mImageUri;

    private   ImageView mProfileImageview;

    private Button mChooseImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mProfileImageview = (ImageView)findViewById(R.id.imageView);

        mChooseImageButton = (Button)findViewById(R.id.Button_id);


        mChooseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ChooseImage();
            }
        });




    }

    private void ChooseImage(){

        Intent Charles = new Intent();
        Charles.setType("image/*");
        Charles.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Charles, PICK_IMAGE_REQUEST);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){

            mImageUri = data.getData();

            mProfileImageview.setImageURI(mImageUri);
        }

    }



}
