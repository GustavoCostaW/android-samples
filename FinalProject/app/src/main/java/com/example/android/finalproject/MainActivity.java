package com.example.android.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

            // Store image in Devise database to send image to mail
//            String path = MediaStore.Images.Media.insertImage(getContentResolver(), photo,"title", null);
//            Uri screenshotUri = (Uri) Uri.parse(data.getExtras().get("URI").toString());
//            final Intent emailIntent1 = new Intent(android.content.Intent.ACTION_SEND);
//            emailIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            emailIntent1.putExtra(Intent.EXTRA_STREAM, screenshotUri);
//            emailIntent1.setType("image/png");
//            startActivity(Intent.createChooser(emailIntent1, "Send email using"));

        }
    }

    public void changeIntent(View view){
        Intent intent = new Intent(this,DoisActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
