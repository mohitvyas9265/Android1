package com.excessrewards.excessrewards;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView camera;
    Button camera_button;
   private static final int RC_PIC_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera=(ImageView)findViewById(R.id.camera);
        camera_button=(Button) findViewById(R.id.camera_button);



    }
    public void OpenCamera(View view)
    {
        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent,RC_PIC_CODE);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==RC_PIC_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                Bitmap bp=(Bitmap)data.getExtras().get("data");
                camera.setScaleType(ImageView.ScaleType.FIT_CENTER);
                camera.setImageBitmap(bp);
            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
