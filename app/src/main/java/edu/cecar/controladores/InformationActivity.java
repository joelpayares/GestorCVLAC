package edu.cecar.controladores;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {
    private TextInputEditText teNombres;
    private TextInputEditText teNacionalidad;
    private TextInputEditText teSexo;
    private TextInputEditText teCategoria;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //Se referencias los elementos graficos
        teNombres = findViewById(R.id.teNombres);
        teNacionalidad = findViewById(R.id.teNacionalidad);
        teSexo = findViewById(R.id.teSexo);
        teCategoria = findViewById(R.id.teCategorizado);
        layout = findViewById(R.id.lista);

        Intent intent = getIntent();
        final String localurlinv = intent.getStringExtra(MainActivity.parurlinv);

        extraerDatosCVLAC(localurlinv);
    }

    public void extraerDatosCVLAC(final String localurlinv) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Investigador investigador = ExtraerDatoCVLAC.getDatosH3(localurlinv);

                adicionarDatosCasillasTexto(investigador);
            }
        }).start();
    }

    public void adicionarDatosCasillasTexto(final Investigador investigador) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                teNombres.setText(investigador.getNombres());
                teNacionalidad.setText(investigador.getNacionalidad());
                teSexo.setText(investigador.getSexo());
                teCategoria.setText(investigador.getCategoria());

                if (investigador.getLineas() != null) {
                    for (int i = 0; i < investigador.getLineas().length; i++) {
                        TextView lineaInvestigacion = new TextView(InformationActivity.this);

                        lineaInvestigacion.setText("Lineas de Investigación\n" + investigador.getLineas()[i]);

                        layout.addView(lineaInvestigacion);
                    }
                }
            }
        });
    }
}
