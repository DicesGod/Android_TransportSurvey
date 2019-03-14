package com.minhle.midtermexam_minhle;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Model.Survey;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    public static  final String  KEY = "ok";
    EditText EditTextClientNumber, EditTextNumberofKm, EditTextPassword;
    Button btnSave,btnNew,btnEnd,btnGo,btnLoad;
    RadioGroup radioGroup;
    ArrayList ListofSurvey;
    static ArrayList ListofClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();

    }

    public void initialize(){

        EditTextClientNumber = findViewById(R.id.editTextClientNumber);
        EditTextNumberofKm = findViewById(R.id.editTextNumberOfKm);
        EditTextPassword = findViewById(R.id.editTextPassword);

        radioGroup = findViewById(R.id.radioGroup);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnNew = findViewById(R.id.btnNew);
        btnEnd = findViewById(R.id.btnEnd);
        btnGo = findViewById(R.id.btnGo);
        btnSave.setOnClickListener(this);
        btnNew.setOnClickListener(this);
        btnEnd.setOnClickListener(this);
        btnGo.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        ListofSurvey = new ArrayList();
        ListofClient = new ArrayList();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLoad:
                if (ListofSurvey.size() != 0){
                    for (int i = 0; i < ListofSurvey.size(); i++) {
                        ListofClient.add(ListofSurvey.get(i));
                    }
                    Toast.makeText(this, "Add Successfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this,"No client to add!",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnEnd:
                finish();
                break;

            case R.id.btnGo:
                if (EditTextPassword.getText().toString().equals("trans")) {
                    try {
                        Intent intent = new Intent(this, Results.class);
                        intent.putExtra(KEY, ListofClient);
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(this,"Please add a survey first!",Toast.LENGTH_LONG).show();
                    }
                }
                else
                    Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnNew:
                EditTextClientNumber.setText("");
                radioGroup.clearCheck();
                EditTextNumberofKm.setText("");
                EditTextPassword.setText("");
                break;

            case R.id.btnSave:
                try {
                    int trans_type = 0;
                    int radiobuttonID = radioGroup.getCheckedRadioButtonId();

                    switch (radiobuttonID) {
                        case R.id.radioButtonBus:
                            trans_type = 1;
                            break;

                        case R.id.radioButtonMetro:
                            trans_type = 2;
                            break;

                        case R.id.radioButtonPrivate:
                            trans_type = 3;
                            break;

                        case R.id.radioButtonTaxi:
                            trans_type = 4;
                            break;
                    }
                    Survey survey = new Survey(Integer.parseInt(EditTextClientNumber.getText().toString()),
                            trans_type,
                            Integer.parseInt(EditTextNumberofKm.getText().toString()));
                    ListofSurvey.add(survey);
                    Snackbar.make(v, survey.toString(),
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(this,"Please input all fields!",Toast.LENGTH_LONG).show();
                }
                break;
        }

    }
}

