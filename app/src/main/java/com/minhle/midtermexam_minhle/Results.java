package com.minhle.midtermexam_minhle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Calculation;

public class Results extends AppCompatActivity implements View.OnClickListener {

    Button btnReturn;
    TextView textViewBusMetro,textViewPrivateTax;
    TextView percentBusMetro,percentPrivateTaxi;
    ArrayList listofSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        initialize();
    }

    public void initialize(){
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

        textViewBusMetro = findViewById(R.id.BusMetro2);
        textViewPrivateTax = findViewById(R.id.PrivateTaxi2);
        percentBusMetro = findViewById(R.id.BusMetroPercent);
        percentPrivateTaxi = findViewById(R.id.PrivateTaxiPercent);

        listofSurvey = (ArrayList) getIntent().getExtras().getSerializable(StartActivity.KEY);

        Calculation cal = new Calculation();
        //Toast.makeText(this,listofSurvey.get(0).toString(),Toast.LENGTH_LONG).show();
        Calculation.calculation(listofSurvey);

        textViewBusMetro.setText(String.valueOf(cal.getTotalClientBusMetro()+"/"+cal.getTotalBusMetroKm()));
        textViewPrivateTax.setText(String.valueOf(cal.getTotalClientPrivateTaxi()+"/"+cal.getTotalPrivateTaxiKm()));

        percentBusMetro.setText(String.valueOf(cal.getPercentBusMetro()+"%"));
        percentPrivateTaxi.setText(String.valueOf(cal.getPercentPrivateTaxi()+"%"));


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
