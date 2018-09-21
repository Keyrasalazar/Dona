package com.example.gmg.donarsangre;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Personas> personasList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){

        Intent i = new Intent(this, Agregar.class);
        startActivityForResult(i,1234);
    }

    @Override
    public void onActivityResult(int request, int respond, Intent data)
    {
        if(request==1234 && respond==RESULT_OK)
        {
            Personas persona=(Personas) data.getExtras().get("persona");
            personasList.add(persona);
        }

    }

    public void onListar(View view){
        Intent i = new Intent(this, BuscarPersona.class);
        startActivity(i);
    }

    public void onEliminar(View view){
        Intent i = new Intent(this, eliminar.class);
        startActivity(i);
    }

    public void premodificar(View view){
        Intent i = new Intent(this, pre_modificar.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
