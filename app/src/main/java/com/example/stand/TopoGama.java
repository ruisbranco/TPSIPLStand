package com.example.stand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class TopoGama extends AppCompatActivity {
    ImageView img;
    Spinner sp;
    String carros [] = {"BMW","Ferrari","Mercedes Benz","Porsche"};
    int imagens [] = {R.drawable.bmw, R.drawable.ferrari,R.drawable.mercedes,R.drawable.porche};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topo_gama);

        img = findViewById(R.id.imagetg);
        sp = findViewById(R.id.spinnertg);

        ArrayAdapter<String> valores = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,carros);
        sp.setAdapter(valores);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img.setImageResource(imagens[i]);
                Toast.makeText(TopoGama.this, "Selecionou:\n"+carros[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    //associar menu a esta activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucarros,menu);
        //remover o back tendo em conta que estamos na pagina para qual ele redireciona
        menu.removeItem(R.id.topogama);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnclose){
            finish();
        }
        if(id == R.id.btnback){
            Intent it = new Intent(TopoGama.this, Standinfo.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.classicos){
            Intent it = new Intent(TopoGama.this, Classicos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.todoterreno){
            Intent it = new Intent(TopoGama.this, TodoTerreno.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}