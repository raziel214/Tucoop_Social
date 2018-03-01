package com.taylor_johnson.realsocialnew.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.taylor_johnson.realsocialnew.Activities.MainActivity;
import com.taylor_johnson.realsocialnew.R;

public class TurnActivity extends AppCompatActivity {

    Button btn_caja;
    Button btn_asesor;
    Button btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);
        showToolbar(getResources().getString(R.string.toolbar_tittle_turn), true);
        btn_asesor=(Button) findViewById(R.id.btn_asesor);
        btn_caja=(Button) findViewById(R.id.btn_caja);
       // btn_home=(Button)findViewById(R.id.homef) ;

        btn_asesor.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TurnActivity.this,TurnInActivity.class);
                startActivity(i);
            }
        });
        btn_caja.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                Intent i = new Intent(TurnActivity.this,TurnInActivity.class);
                startActivity(i);

            }
        });
       /* btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TurnActivity.this,MainActivity.class);
                startActivity(i);

            }
        });*/





    }

    private void showToolbar(String tittle, boolean upButton) {

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
