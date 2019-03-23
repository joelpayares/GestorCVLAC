package edu.cecar.controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class EstadisticasActivity extends AppCompatActivity {
    EditText txtconhom;
    EditText txtconmuj;
    EditText txtconcat;
    EditText txtconsincat;
    EditText txtconlininv;
    EditText txtconsininv;

    Investigador objconinv;
    int conhom = 0, conmuj = 0, concat = 0, consincat = 0, conlininv = 0, consininv = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        txtconhom = findViewById(R.id.txtHombre);
        txtconmuj = findViewById(R.id.txtMujer);
        txtconcat = findViewById(R.id.txtCategorizado);
        txtconsincat = findViewById(R.id.txtNoCategorizado);
        txtconlininv = findViewById(R.id.txtConLinea);
        txtconsininv = findViewById(R.id.txtSinLinea);

        Investigadores objdatinv = new Investigadores(0);

        for (int i = 0; i < 5; i++) {
            extraerInvestigador(objdatinv.matdatinv[i].urlinv);
        }
    }

    private void extraerInvestigador(final String parurlinv) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                objconinv = ExtraerDatoCVLAC.getDatosH3(parurlinv);

                if (objconinv.getSexo().trim().charAt(0) == 'M') {
                    conhom = conhom + 1;

                    Log.i("Hombre: ", "" + conhom);
                } else if (objconinv.getSexo().trim().charAt(0) == 'F') {
                    conmuj = conmuj + 1;
                    Log.i("Mujer: ", "" + conmuj);
                }

                if (objconinv.isCategorizado() == true) {
                    concat = concat + 1;
                    Log.i("Categorizado: ", "" + concat);
                } else {
                    consincat = consincat + 1;
                    Log.i("No Categorizado: ", "" + consincat);
                }

                if (objconinv.getLineas().length > 0) {
                    conlininv = conlininv + 1;
                    Log.i("Con Lineas: ", "" + conlininv);
                } else {
                    consininv = consininv + 1;
                    Log.i("Sin Lineas: ", "" + consininv);
                }
            }
        }).start();

        txtconhom.setText(conhom);
        txtconmuj.setText(conmuj);
        txtconcat.setText(concat);
        txtconsincat.setText(consincat);
        txtconlininv.setText(conlininv);
        txtconsininv.setText(consininv);
    }
}
