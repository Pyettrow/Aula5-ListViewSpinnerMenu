package com.view.aula5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class DetalhePessoa extends ListActivity {
    TextView tvNome;
    Spinner spUFS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pessoa);

        tvNome = (TextView) findViewById(R.id.tvNome);
        spUFS = (Spinner) findViewById(R.id.spUFS);

        Intent intent = getIntent();

        ArrayAdapter<CharSequence> uf = ArrayAdapter.createFromResource(this, R.array.lista_ufs, android.R.layout.simple_spinner_item);
        spUFS.setAdapter(uf);

        if(intent != null){
            String nome = intent.getStringExtra("nome");
            tvNome.setText(nome);

            spUFS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ArrayAdapter<String> adapter = new ArrayAdapter(DetalhePessoa.this, android.R.layout.simple_list_item_1,retornaCidade(i));
                    setListAdapter(adapter);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }else{
            Toast.makeText(this, "Problema com troca de dados!", Toast.LENGTH_SHORT).show();
        }

    }

    private List<String> retornaCidade(int pos){
        String[] array = null;
        if(pos == 0){
            array = new String[]{"VENÂNCIO AIRES", "BOM RETIRO DO SUL", "SANTA CRUS DO SUL"};
        }else if(pos == 1){
            array = new String[]{"JOINVILLE", "BLUMENAU", "FLORIPA"};
        }else if (pos == 2){
            array = new String[]{"MARINGA","CURITIBA","LONDRINA"};
        }
        return Arrays.asList(array);
    }
}
