package com.josrangel.sharedpreferencesejemplo;

import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int contador;
    int color;

    TextView numero;
    private SharedPreferences sharedPreferences;
    public static String sharePrefFile="com.josrangel.sharedpreferncesejemplo.sp";
    public static String llaveContador="contador";
    public static String llaveColor="color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = findViewById(R.id.numero);

        color=ContextCompat.getColor(this, R.color.negro);
        sharedPreferences = getSharedPreferences(sharePrefFile, MODE_PRIVATE);
        contador = sharedPreferences.getInt(llaveContador,0);
        color = sharedPreferences.getInt(llaveColor,color);

        numero.setText(String.valueOf(contador));
        numero.setBackgroundColor(color);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(llaveContador,contador);
        editor.putInt(llaveColor,color);
        editor.apply();
    }

    public void reset(View v){
        contador=0;
        numero.setText(String.valueOf(contador));
    }

    public void incrementa(View v){
        contador++;
        numero.setText(String.valueOf(contador));
    }

    public void cambiaColor(View v){
        if(v.getId() == R.id.btnNegro){
            color = ContextCompat.getColor(this, R.color.negro);
        }else if(v.getId() == R.id.btnRojo){
            color = ContextCompat.getColor(this, R.color.rojo);
        }else if(v.getId() == R.id.btnAzul){
            color = ContextCompat.getColor(this, R.color.azul);
        }else if(v.getId() == R.id.btnVerde){
            color = ContextCompat.getColor(this, R.color.verde);
        }

        numero.setBackgroundColor(color);
    }

}