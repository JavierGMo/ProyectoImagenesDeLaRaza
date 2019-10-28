package com.morajavier.raza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button jBtnRaza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jBtnRaza = findViewById(R.id.xbtnListImage);
        jBtnRaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Proyecto 1", Toast.LENGTH_SHORT).show();
                Intent intentProyectoRaza = new Intent(MainActivity.this, ListRazaActivity.class);
                startActivity(intentProyectoRaza);
            }
        });
    }
}
