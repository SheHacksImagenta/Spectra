package com.example.shalini.spectra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }

    public void setSingleEvent(GridLayout mainGrid){
        for(int i = 0; i < mainGrid.getChildCount(); i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener(){
               public void onClick(View view){
                   //Toast.makeText(MainActivity.this, "Clicked at " + finalI, Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this, ShowHappyActivity.class);
                   startActivity(intent);
               }
            });
        }
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            ImageView mImageView;
//            mImageView.setImageBitmap(imageBitmap);
//        }
//    }

//    public void happyResponse(View view){
//        Intent intent = new Intent(this, ShowHappyActivity.class);
//        startActivity(intent);
//    }
//
//    public void submitLogin(View view){
//        Intent intent = new Intent(this, LoggedActivity.class);
//        startActivity(intent);
//    }

}
