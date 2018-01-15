package de.htwsaar.joshua.lasercontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton pen,usb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pen = (ImageButton) findViewById(R.id.penBtn);
        usb = (ImageButton) findViewById(R.id.usbBtn);

        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent penIntent = new Intent(MainActivity.this,PenActivity.class);
                startActivity(penIntent);

            }
        });

        usb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent usbIntent = new Intent(MainActivity.this, UsbActivity.class);
                startActivity(usbIntent);
            }
        });

    }
}
