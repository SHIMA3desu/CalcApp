package com.example.qcq0447.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultGamen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_gamen);

        Intent intent = getIntent();
        String  st01 = intent.getStringExtra("VAL3");
        Double db01 = intent.getDoubleExtra("VAL1", 12.0);
        Double db02 = intent.getDoubleExtra("VAL2", 3.0);
        TextView textView = (TextView) findViewById(R.id.tv_no3);
        Double dball = 0.0;
        Log.d("TESTJAVA",st01);
        if(st01.equals("+") ){
            dball = db01 + db02;
        } else if (st01.equals("-")){
            dball = db01 - db02;
        } else if (st01.equals("x")){
            dball = db01 * db02;
        } else if (st01.equals("/")){
            dball = db01 / db02;
        }

        textView.setText(String.valueOf(dball));

    }
}
