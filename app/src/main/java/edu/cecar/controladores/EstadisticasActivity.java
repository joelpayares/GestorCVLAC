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
    int conhom=0,conmuj=0, concat=0,consincat=0, conlininv=0,consininv=0;

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

        for (int i=0;i<5;i++)
        {
            extraerInvestigador(objdatinv.matdatinv[i].urlinv);
        }

        Log.i("Hombres", "" + conhom);

//        txtconhom.setText(conhom);
//        txtconmuj.setText(conmuj);
//        txtconcat.setText(concat);
//        txtconsincat.setText(consincat);
//        txtconlininv.setText(conlininv);
//        txtconsininv.setText(consininv);
    }

    private void extraerInvestigador(final String parurlinv) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Log.i("1", "Antes de extraer datos de investigador");

                objconinv = ExtraerDatoCVLAC.getDatosH3(parurlinv);

                Log.i("2", "Despues de extraer datos de investigador");

                extraerEstadisticas(objconinv);
            }
        }).start();
    }


    public void extraerEstadisticas(Investigador objconinv) {

//        if (objconinv == null)
//            Log.i("3", "No se ha inicializado el investigador " + i);
//        else
//            Log.i("4", "Se ha inicializado el investigador " + i);

        if (objconinv.getSexo().trim().charAt(0)=='M')
        {
            conhom=conhom+1;
        }
        else
        {
            if (objconinv.getSexo().trim().charAt(0)=='F')
            {
                conmuj=conmuj+1;
            }
        }

        if (objconinv.isCategorizado()==true)
        {
            concat=concat+1;
        }
        else
        {
            consincat=consincat+1;
        }

        if (objconinv.getLineas().length>0)
        {
            conlininv=conlininv+1;
        }
        else
        {
            consininv=consininv+1;
        }
    }
}
