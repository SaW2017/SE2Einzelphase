package com.example.hp.se2einzelphase;

import android.app.AlertDialog;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCalc;                     //Button zum Durchführen der Division
    private EditText edDivisor, edDividend;     //Eingabefelder
    private TextView edOutput;                  //Ausgabewert


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Methode um Werte zu initialisieren wird bei Start der App aufgerufen
        initialisiere();
    }

    //Objekte erstellen mit dem jeweiligen Verweis auf das zugehörige Textfeld
    private void initialisiere(){
        btnCalc = (Button)findViewById(R.id.btnCalc);
        edDivisor = (EditText)findViewById(R.id.edDivisor);
        edDividend = (EditText)findViewById(R.id.edDividend);
        edOutput = (TextView)findViewById(R.id.edOutput);

        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Inhalt (Objekt) des jeweiligen Textfeldes abrufen und in Stringvariable konvertieren
        String divisor = edDivisor.getText().toString();
        String dividend = edDividend.getText().toString();


       try {
           //Bedingung dass Divisor !=0 ist
           if (!divisor.equals("0")) {

               //String in Float umwandeln
               double flDivisor = Double.parseDouble(divisor);
               double flDividend = Double.parseDouble(dividend);

               //Berechung durchführen und in float ergebnis speichern
               double ergebnis = (flDividend/flDivisor) ;

               //Ergebnis in Feld Output speichern und vorher in Stringvariable konvertieren
               edOutput.setText(Double.toString(ergebnis));

               //Fehlermeldung bei Division durch 0
           } else {
               //Fehlerdialog erstellen
               AlertDialog.Builder error = new AlertDialog.Builder(this);
               error.setTitle("Fehler!");
               error.setMessage("Durch 0 dividieren ist nicht möglich!");
               error.setCancelable(true);

               //Fehlerdialog anzeigen
               AlertDialog errorDialog = error.create();
               errorDialog.show();
           }
       }catch(Exception e){
           edOutput.setText("Division nicht möglich!");
       }
    }
}
