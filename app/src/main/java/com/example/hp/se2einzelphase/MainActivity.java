package com.example.hp.se2einzelphase;

import android.app.AlertDialog;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

    //in dieser Methode wird festgelegt was passiert wenn man auf den "Dividiere-Button" drückt
    @Override
    public void onClick(View v) {

        //Inhalt (Objekt) des jeweiligen Textfeldes abrufen und in Stringvariable konvertieren
        String divisor = edDivisor.getText().toString();
        String dividend = edDividend.getText().toString();


       try {

           //prüft ob Wert bei Divisor eingegeben wurde
           if(TextUtils.isEmpty(divisor)) {
               edOutput.setText("Bitte erst Wert für Divisor eingeben!");

           //prüft dasselbe bei Dividend
           }else if(TextUtils.isEmpty(dividend)){
               edOutput.setText("Bitte erst Wert für Dividend eingeben!");

           }else {
               //Bedingung dass Divisor !=0 ist
               if (!divisor.equals("0")) {

                   //String in Double umwandeln
                   double dlDivisor = Double.parseDouble(divisor);
                   double dlDividend = Double.parseDouble(dividend);

                   //Berechung durchführen und in double ergebnis speichern
                   double ergebnis = (dlDividend / dlDivisor);

                   //Ergebnis in Feld Output speichern und vorher in Stringvariable konvertieren
                   edOutput.setText(Double.toString(ergebnis));

                   //Fehlermeldung bei Division durch 0
               } else {
                   showError();
               }

           } //Zur Sicherheit ein try,catch Block um das Programm vorm Abstürzen zu bewahren
       }catch(Exception e){
           edOutput.setText("Division leider nicht möglich!");
       }
    }
    //eigene Methode für Fehlermeldungen per Dialogfenster
    public void showError(){

        //Fehlerdialog erstellen
        AlertDialog.Builder error = new AlertDialog.Builder(this);
        error.setTitle("Fehler!");
        error.setMessage("Durch 0 dividieren ist nicht möglich!");
        error.setCancelable(true);

        //Fehlerdialog anzeigen
        AlertDialog errorDialog = error.create();
        errorDialog.show();


        /*
        Möglichkeit für weitere Fehlermeldungen
        AlertDialog.Builder error2 = new AlertDialog.Builder(this);
        error2.setTitle("Fehler!");
        error2.setMessage("Bitte zuerst Zahlen eingeben!");
        error2.setCancelable(true);*/


    }
}
