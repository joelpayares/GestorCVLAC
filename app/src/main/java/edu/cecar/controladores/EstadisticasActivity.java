package edu.cecar.controladores;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EstadisticasActivity extends AppCompatActivity {
    TextInputEditText txtconhom;
    TextInputEditText txtconmuj;
    TextInputEditText txtconcat;
    TextInputEditText txtconsincat;
    TextInputEditText txtconlininv;
    TextInputEditText txtconsininv;

    Investigador objconinv;
    int conhom = 0;
    int conmuj = 0;
    int concat = 0;
    int consincat = 0;
    int conlininv = 0;
    int consininv = 0;

    private boolean conest = false;

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
            extraerInvestigador(objdatinv.matdatinv[i].urlinv, i);
        }

        runOnUiThread(()->methodToRun());
    }

    private void methodToRun() {
        boolean loccon = false;

        while(!loccon){
            if (conest){
                loccon = true;

                txtconhom.setText("" + conhom);
                txtconmuj.setText("" + conmuj);
                txtconcat.setText("" + concat);
                txtconsincat.setText("" + consincat);
                txtconlininv.setText("" + conlininv);
                txtconsininv.setText("" + consininv);
            }
        }
    }

    private synchronized void extraerInvestigador(final String parurlinv, final int parconinv) {
        Thread t = new Thread(() -> {
            objconinv = ExtraerDatoCVLAC.getDatosH3(parurlinv);

            if (objconinv.getSexo().trim().charAt(0) == 'M') {
                conhom = conhom + 1;
            } else if (objconinv.getSexo().trim().charAt(0) == 'F') {
                conmuj = conmuj + 1;
            }

            if (objconinv.isCategorizado()) {
                concat = concat + 1;
            } else {
                consincat = consincat + 1;
            }

            if (objconinv.getLineas().length > 0) {
                conlininv = conlininv + 1;
            } else {
                consininv = consininv + 1;
            }

            if (parconinv == 4){
                conest = true;
            }
        });

        t.start();
    }
}
