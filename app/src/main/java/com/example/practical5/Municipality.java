package com.example.practical5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Municipality extends AppCompatActivity {
    public static final String EXTRA_MUNICIPALITY = "com.example.practicalfive.extra.MUNICIPALITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        TextView nameView = findViewById(R.id.textMunicipalityName);
        ImageView imageView = findViewById(R.id.imageMunicipality);
        TextView infoView = findViewById(R.id.textMunicipalityInfo);

        String rawName = getIntent().getStringExtra(EXTRA_MUNICIPALITY);
        String municipalityName = TextProcessor.processMunicipality(rawName);

        if (municipalityName == null) {
            Toast.makeText(this, R.string.missing_municipality, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        int colorRes = 0;
        int imageRes = 0;
        int infoIndex = 0;

        switch (municipalityName) {
            case "Beijing":
                colorRes = R.color.municipality_beijing;
                imageRes = R.drawable.beijing;
                infoIndex = 0;
                break;
            case "Shanghai":
                colorRes = R.color.municipality_shanghai;
                imageRes = R.drawable.shanghai;
                infoIndex = 1;
                break;
            case "Chongqing":
                colorRes = R.color.municipality_chongqing;
                imageRes = R.drawable.chongqing;
                infoIndex = 2;
                break;
            case "Tianjin":
                colorRes = R.color.municipality_tianjin;
                imageRes = R.drawable.tianjin;
                infoIndex = 3;
                break;
        }

        int municipalityColor = ContextCompat.getColor(this, colorRes);
        int textLightColor = ContextCompat.getColor(this, R.color.color_textlight);

        nameView.setText(municipalityName);
        nameView.setBackgroundColor(municipalityColor);
        nameView.setTextColor(textLightColor);

        imageView.setImageResource(imageRes);

        String[] summaries = getResources().getStringArray(R.array.municipalities_array);
        infoView.setText(summaries[infoIndex]);
        infoView.setTextColor(municipalityColor);
    }
}