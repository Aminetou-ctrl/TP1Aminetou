package com.example.tp1aminetou;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText nameEdt,ageEdt,tailleEdt;
    Button okBtn;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    private void initViews() {
        nameEdt = findViewById(R.id.nameEdt);
        ageEdt = findViewById(R.id.ageEdt);
        tailleEdt = findViewById(R.id.tailleEdt);
        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Log.v(TAG,"Données envoyées pour traitement …");
        if (v.getId() == R.id.okBtn) {
            if (isEditTextEmpty(nameEdt) || isEditTextEmpty(ageEdt)|| isEditTextEmpty(tailleEdt))
                return;

            Intent intent = new Intent(getBaseContext(), Second_Activity.class);

            /*
            Bundle bundle = new Bundle();
            bundle.putString("first_number", firstEdt.getText().toString());
            bundle.putString("second_number", secondEdt.getText().toString());
            intent.putExtra("data", bundle);
            */
            intent.putExtra("nom", nameEdt.getText().toString());
            intent.putExtra("age", ageEdt.getText().toString());
            intent.putExtra("taille", tailleEdt.getText().toString());
            startActivity(intent);
        }
    }

    private boolean isEditTextEmpty(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            editText.requestFocus();
            editText.setError("Champ obligatoire!");
            return true;
        }
        return false;
    }


}
