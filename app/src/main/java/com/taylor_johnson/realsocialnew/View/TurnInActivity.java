package com.taylor_johnson.realsocialnew.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.taylor_johnson.realsocialnew.Activities.MainActivity;
import com.taylor_johnson.realsocialnew.R;



public class TurnInActivity extends AppCompatActivity {


    private Button btn_home;
    private Button btn_turno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_in);
        showToolbar(getResources().getString(R.string.toolbar_tittle_turn), false);
         btn_home=(Button)findViewById(R.id.home_buttom) ;
        btn_turno=(Button)findViewById(R.id.btn_turno1);

        Spinner spinner1=(Spinner)findViewById(R.id.spr_tipo);
        Spinner spinner=(Spinner)findViewById(R.id.spr_sexo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipodocs_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.sexo_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);

        addListenerOnButton();




    }

    private void addListenerOnButton() {

        btn_turno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int)Math.ceil(Math.random()*100);

                Toast.makeText(getApplicationContext(),"el turno asignado es:"+random,Toast.LENGTH_SHORT).show();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //de esta manera se crea una nueva tarea y se llama el activity
                Intent i = new Intent(TurnInActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }


    private void showToolbar(String tittle, boolean upButton) {

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
