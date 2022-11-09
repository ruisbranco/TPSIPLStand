package com.example.stand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Standinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standinfo);
    }
//associar menu a esta activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucarros,menu);
        //remover o back tendo em conta que estamos na pagina para qual ele redireciona
        menu.removeItem(R.id.btnback);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnclose){
            finish();
        }
        if(id == R.id.classicos){
            Intent it = new Intent(Standinfo.this, Classicos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.todoterreno){
            Intent it = new Intent(Standinfo.this, TodoTerreno.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.topogama){
            Intent it = new Intent(Standinfo.this, TopoGama.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}