package de.htwsaar.joshua.lasercontroller;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class UsbActivity extends AppCompatActivity {
    private Typeface tf;
    private EditText et;
    private TextView tv;
    private Spinner spn;
    private Button btnSend;
    private ImageButton camBtn;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usb);

        tv = findViewById(R.id.text_on_usb);
        et = findViewById(R.id.text_input);
        spn = findViewById(R.id.spnFontStyle);
        btnSend = findViewById(R.id.btnSend);
        camBtn = findViewById(R.id.camBtn);

        adapter =ArrayAdapter.createFromResource(this, R.array.spnFontStyle, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                tf = Typeface.createFromAsset(getAssets(),adapterView.getSelectedItem().toString()+".ttf");
                tv.setTypeface(tf);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        et.addTextChangedListener(createTextWatcher());

        // Button zum öffnen der Kamera-Activity
        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Button zum HTTP POST senden
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    /**
     * Creates TextWatcher for text_on_pen element
     * @return TextWatcher for et
     */
    private TextWatcher createTextWatcher(){
        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tv.setText(et.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        return tw;
    }
}


