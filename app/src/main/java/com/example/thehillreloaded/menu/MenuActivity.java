package com.example.thehillreloaded.menu;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.thehillreloaded.R;
import com.example.thehillreloaded.accesso.LoginActivity;
import com.example.thehillreloaded.accesso.ModalitaAccessoActivity;
import com.example.thehillreloaded.animazioni.Animazioni;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuActivity extends Animazioni implements View.OnClickListener{

    //Variabili
    public CardView giocatoreSingolo, multigiocatore;
    public ImageView logout, impostazioni, cronologia, punteggi;
    public static double screenRatioX, screenRatioY, densityRatio;
    public static String modalità;
    public static boolean accesso;

    //Chiama l'animazione all'avvio dell'activity
    @Override
    protected void onStart(){
        super.onStart();
        runAnimationSlideIn(giocatoreSingolo);
        runAnimationSlideIn(multigiocatore);
        SharedPreferences preferenze = getSharedPreferences("salva1",MODE_PRIVATE);
        boolean b = preferenze.getBoolean("musica",true);
        if(b) {
            if (VolumeActivity.flagMusic == 0) {
                MusicPlayer.playMusic(this, R.raw.menu_music);
                ModalitaAccessoActivity.isPlayingAudio = true;
                VolumeActivity.flagMusic = 1;
            }
        }
    }

    //Chiama l'animazione alla pausa dell'activity
    @Override
    protected void onPause(){
        super.onPause();
        runAnimationSlideOut(giocatoreSingolo);
        runAnimationSlideOut(multigiocatore);
    }

    @Override
    public void onBackPressed() {

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Imposta l'orientamento portrait come obbligatorio
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Trova le view tramite l'id e le assegna alle variabili
        giocatoreSingolo = findViewById(R.id.giocatoreSingolo);
        multigiocatore = findViewById(R.id.multigiocatore);
        logout = findViewById(R.id.logout);
        impostazioni = findViewById(R.id.impostazioni);
        cronologia = findViewById(R.id.cronologia);
        punteggi = findViewById(R.id.punteggi);

        //Imposta metodo di callback quando la view viene cliccata
        multigiocatore.setOnClickListener(this);
        giocatoreSingolo.setOnClickListener(this);
        logout.setOnClickListener(this);
        impostazioni.setOnClickListener(this);
        cronologia.setOnClickListener(this);
        punteggi.setOnClickListener(this);

        //Animazione pulsanti
        clickButtonAnimation(giocatoreSingolo);
        clickButtonAnimation(multigiocatore);
        clickButtonAnimation(logout);
        clickButtonAnimation(impostazioni);
        clickButtonAnimation(cronologia);
        clickButtonAnimation(punteggi);
    }

    //Crea l'intent per passare all'activity successiva dopo la pressione di un pulsante
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.giocatoreSingolo:
                i = new Intent(this, GiocatoreSingoloActivity.class);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(i, b);
                break;
            case R.id.multigiocatore:
                i = new Intent(this, MultigiocatoreActivity.class);
                Bundle b1 = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(i,b1);
                break;
            case R.id.logout:
                LoginActivity.currentUser = null;
                i = new Intent(this, ModalitaAccessoActivity.class);
                Bundle b2 = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(i,b2);
                finish();
                break;
            case R.id.impostazioni:
                i = new Intent(this, ImpostazioniActivity.class);
                Bundle b3 = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(i,b3);
                break;
            case R.id.cronologia:
                i = new Intent(this, PunteggiActivity.class);
                Bundle b4 = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(i,b4);
                break;
            case R.id.punteggi:
                i = new Intent(this, ClassificaActivity.class);
                Bundle b5 = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(i,b5);
                break;

        }
    }
}