package edu.cecar.controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EstadisticasActivity extends AppCompatActivity {

    EditText txtconhom;
    EditText txtconmuj;
    EditText txtconcat;
    EditText txtconsincat;
    EditText txtconlininv;
    EditText txtconsininv;
    LinearLayout layoutSexo;

    int esconhom = 0;
    int conmuj = 0;
    int concat = 0;
    int consincat = 0;
    int conlininv = 0;
    int consininv = 0;

    Investigador objconinv = new Investigador();
    boolean estcon = false;

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
        layoutSexo = findViewById(R.id.layoutSexo);

        Investigadores objdatinv = new Investigadores(0);

        for (int i = 0; i < 5; i++) {
            extraerInvestigador(objdatinv.matdatinv[i].urlinv, i);
        }

        Log.i("Antes de runable", "" + estcon);

        runOnUiThread(new Runnable() {
            public void run() {
                int con = 0;

                boolean locconeje = false;

                Log.i("runable ejecutando", "" + estcon);

                while(!locconeje){
                    con=con+1;
                    Log.i("while contando", "" + con);

                    if (estcon == true){
                        Log.i("while ejecutando", "" + estcon);
                        locconeje = true;

                        Toast.makeText(EstadisticasActivity.this, "Terminado", Toast.LENGTH_LONG).show();
                        txtconhom.setText("" + esconhom);
                        estcon = false;

                    }
                }
            }
        });
    }

    private synchronized void extraerInvestigador(final String parurlinv, final int parnuminv) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                objconinv = ExtraerDatoCVLAC.getDatosH3(parurlinv);

                Log.i("Investigador", "" + parnuminv);

                if (objconinv.getSexo().trim().charAt(0) == 'M') {
                    esconhom = esconhom + 1;
                    Log.i("Estadistica Hombres", "" + esconhom);
                } else if (objconinv.getSexo().trim().charAt(0) == 'F') {
                    conmuj = conmuj + 1;
                    Log.i("Estadistica Mujeres", "" + conmuj);
                }

                if (objconinv.isCategorizado() == true) {
                    concat = concat + 1;
                    Log.i("Estadistica Cate", "" + concat);
                } else {
                    consincat = consincat + 1;
                    Log.i("Estadistica Sin Cate", "" + consincat);
                }

                if (objconinv.getLineas().length > 0) {
                    conlininv = conlininv + 1;
                    Log.i("Estadistica Lineas", "" + conlininv);
                } else {
                    consininv = consininv + 1;
                    Log.i("Estadistica Sin Lineas", "" + consininv);
                }

                if (parnuminv == 4) {
                    Log.i("Investigador", "" + parnuminv);
                    estcon = true;
                    Log.i("Cambiando estado", "" + estcon);
                }
            }
        }).start();
    }
}