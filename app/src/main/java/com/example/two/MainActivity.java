package com.example.two;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ubidots.ApiClient;
import com.ubidots.Variable;

public class MainActivity extends Activity {

    EditText sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8;
    EditText creds1,creds2,creds3,creds4,creds5,creds6,creds7,creds8;
    TextView disp;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get gpas
        sgpa1 = findViewById(R.id.gpa1);
        sgpa2 = findViewById(R.id.gpa2);
        sgpa3 = findViewById(R.id.gpa3);
        sgpa4 = findViewById(R.id.gpa4);
        sgpa5 = findViewById(R.id.gpa5);
        sgpa6 = findViewById(R.id.gpa6);
        sgpa7 = findViewById(R.id.gpa7);
        sgpa8 = findViewById(R.id.gpa8);

        //get creds, if any changes have been made
        creds1 = findViewById(R.id.cred1);
        creds2 = findViewById(R.id.cred2);
        creds3 = findViewById(R.id.cred3);
        creds4 = findViewById(R.id.cred4);
        creds5 = findViewById(R.id.cred5);
        creds6 = findViewById(R.id.cred6);
        creds7 = findViewById(R.id.cred7);
        creds8 = findViewById(R.id.cred8);

        disp = findViewById(R.id.result);
        b1 = findViewById(R.id.calculate);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int credSum = 0;
                double gpaSum = 0;
                int creds = 0;
                //check gpa,creds and add
                if(!TextUtils.isEmpty(creds1.getText()) && !TextUtils.isEmpty(sgpa1.getText()))
                {
                    creds = Integer.parseInt(creds1.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa1.getText().toString())*creds);
                }
                if(!TextUtils.isEmpty(creds2.getText()) && !TextUtils.isEmpty(sgpa2.getText()))
                {
                    creds = Integer.parseInt(creds2.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa2.getText().toString()) * creds);
                }
                if(!TextUtils.isEmpty(creds3.getText()) && !TextUtils.isEmpty(sgpa3.getText()))
                {
                    creds = Integer.parseInt(creds3.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa3.getText().toString()) * creds);
                }
                if(!TextUtils.isEmpty(creds4.getText()) && !TextUtils.isEmpty(sgpa4.getText()))
                {
                    creds = Integer.parseInt(creds4.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa4.getText().toString()) * creds);
                }
                if(!TextUtils.isEmpty(creds5.getText()) && !TextUtils.isEmpty(sgpa5.getText()))
                {
                    creds = Integer.parseInt(creds5.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa5.getText().toString()) * creds);
                }
                if(!TextUtils.isEmpty(creds6.getText()) && !TextUtils.isEmpty(sgpa6.getText()))
                {
                    creds = Integer.parseInt(creds6.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa6.getText().toString()) * creds);
                }
                if(!TextUtils.isEmpty(creds7.getText()) && !TextUtils.isEmpty(sgpa7.getText()))
                {
                    creds = Integer.parseInt(creds7.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa7.getText().toString()) * creds);
                }
                if(!TextUtils.isEmpty(creds8.getText()) && !TextUtils.isEmpty(sgpa8.getText()))
                {
                    creds = Integer.parseInt(creds8.getText().toString());
                    credSum += creds;
                    gpaSum += (Double.parseDouble(sgpa8.getText().toString()) * creds);
                }

                double result;

                if(credSum > 0)
                {
                    result = gpaSum/credSum;
                    result = Math.round(result * 100.0) / 100.0;
                }
                else
                    result = 0.0;

                disp.setText("Current CGPA:"+result);
            }
        });
    }
}