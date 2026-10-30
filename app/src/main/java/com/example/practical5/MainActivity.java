package com.example.practical5;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText municipalityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        municipalityInput = findViewById(R.id.editMunicipality);

        municipalityInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                submitMunicipality();
                return true;
            }
            return false;
        });
    }

    private void submitMunicipality() {
        String rawInput = municipalityInput.getText().toString();
        String normalizedName = TextProcessor.processMunicipality(rawInput);

        if (normalizedName == null) {
            Toast.makeText(this, R.string.invalid_municipality, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, Municipality.class);
        intent.putExtra(Municipality.EXTRA_MUNICIPALITY, normalizedName);
        startActivity(intent);
    }
}