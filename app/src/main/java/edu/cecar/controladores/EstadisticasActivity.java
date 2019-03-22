package edu.cecar.controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EstadisticasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);


    }

    public void extraerEstadisticas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Investigador investigador = ExtraerDatoCVLAC.getDatosH3();

                //adicionarDatosCasillasTexto(investigador);
            }
        }).start();
    }
}
