package edu.cecar.controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<String, String> listadoInvestigador = new HashMap<>();
    public static final String PARURLINV = "parurlinv";

    ListView lista;
    Button btnEstadisticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        btnEstadisticas = findViewById(R.id.btnEstadisticas);

        listadoInvestigador.put("Guillermo Carlos Hernández Hernández", "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001376707");
        listadoInvestigador.put("Luty Del Carmen Gomezcaceres Peréz", "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478");
        listadoInvestigador.put("Jhon Jaime Mendez Alandete", "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180");
        listadoInvestigador.put("Namuel Francisco Solórzano Peralta", "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000787132");
        listadoInvestigador.put("Adriana Patricia Arboleda Lopez", "http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001414537");

        String[] nomInv = new String[listadoInvestigador.size()];

        for (int i = 0; i < listadoInvestigador.size(); i ++){
            nomInv[i] = (String) listadoInvestigador.keySet().toArray()[i];
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, nomInv);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                intent.putExtra(PARURLINV, listadoInvestigador.get(parent.getAdapter().getItem(position)));
                startActivity(intent);
            }
        });

        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EstadisticasActivity.class);
                startActivity(intent);
            }
        });
    }
}