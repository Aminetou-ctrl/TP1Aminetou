package com.example.tp1aminetou;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView nameTxt,ageTxt,tailleTxt;
    Button retourBtn;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        initViews();
        getDataFromFirstActivityIntent();
    }
    private void initViews() {
        nameTxt = findViewById(R.id.nameTxt);
        ageTxt = findViewById(R.id.ageTxt);
        tailleTxt = findViewById(R.id.tailleTxt);
        retourBtn=findViewById(R.id.retourBtn);
        retourBtn.setOnClickListener(this);
    }
    private void getDataFromFirstActivityIntent() {

        nameTxt.setText(getIntent().getStringExtra("nom"));
        ageTxt.setText(getIntent().getStringExtra("age"));
        tailleTxt.setText(getIntent().getStringExtra("taille"));

        /*
        Bundle bundle = getIntent().getBundleExtra("data");
        firstTxt.setText(bundle.getString("first_number"));
        secondTxt.setText(bundle.getString("second_number"));
        */

        int result = Integer.parseInt(tailleTxt.getText().toString()) ;
        tailleTxt.setText(String.valueOf(result));
        if(result==170){
        tailleTxt.setText("moyenne");}
        else {if(result<170)
            tailleTxt.setText("courte");

                else tailleTxt.setText("elancée");

    }
      Log.i(TAG,"Traitement réussi, données reçues.");
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.retourBtn) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
