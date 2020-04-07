package com.view.aula5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Linka o menu criado no XML com essa Activity, para ações que forem feitas lá serem tratadas aqui
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meumenu, menu);

         return true;
    }

    //Tratando o clique no item lá no menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Colocar o chamado da outra tela aqui
        if(item.getItemId() == R.id.lista){
            Intent it = new Intent(this, ListasDasPessoas.class);
            startActivity(it);
            return true;
        }
        return false;
    }
}
