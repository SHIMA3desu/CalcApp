package com.example.qcq0447.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et01;
    EditText et02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et01 = (EditText) findViewById(R.id.et_no1);
        et02 = (EditText) findViewById(R.id.et_no2);

        Button bt01 = (Button) findViewById(R.id.bt_no1);
        bt01.setOnClickListener(this);
        Button bt02 = (Button) findViewById(R.id.bt_no2);
        bt02.setOnClickListener(this);
        Button bt03 = (Button) findViewById(R.id.bt_no3);
        bt03.setOnClickListener(this);
        Button bt04 = (Button) findViewById(R.id.bt_no4);
        bt04.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String calcnum = "";
        if (v.getId() == R.id.bt_no1) {
            calcnum = "+";
        } else if (v.getId() == R.id.bt_no2) {
            calcnum = "-";
        } else if (v.getId() == R.id.bt_no3) {
            calcnum = "x";
        }else if (v.getId() == R.id.bt_no4) {
            calcnum = "/";
        }

        Intent intent = new Intent(this, ResultGamen.class);
        String st01 = et01.getText().toString();
        String st02 = et02.getText().toString();
        Log.d("JAVATEST",st01);
        Log.d("JAVATEST",st02);

        String ermsg ="";
        if(st01.length() == 0){
            ermsg ="★上段に値をセットして下さい";
        }

        if(calcnum.equals("/")){
            if(st02.length() == 0){
                ermsg += "★割り算では下段に値をセットしてください";
            }
        } else if (st02.length() == 0){
            ermsg +="★下段に値をセットして下さい";
        }
        if(ermsg.equals("")){
            double db1 = Double.parseDouble(st01);
            double db2 = Double.parseDouble(st02);
            intent.putExtra("VAL1",db1);
            intent.putExtra("VAL2",db2);
            intent.putExtra("VAL3",calcnum);

            startActivity(intent);
        } else{
            Toast.makeText(this,ermsg,Toast.LENGTH_LONG).show();
        }


    }

}