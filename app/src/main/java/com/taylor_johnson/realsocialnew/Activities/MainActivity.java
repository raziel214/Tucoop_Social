package com.taylor_johnson.realsocialnew.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.AdapterRecyclerView;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListenerRedes;
import com.taylor_johnson.realsocialnew.Api.OpcionesResult;
import com.taylor_johnson.realsocialnew.Api.OptionsApiResponse;
import com.taylor_johnson.realsocialnew.Api.RealsocialClient;
import com.taylor_johnson.realsocialnew.Api.RealsocialService;
import com.taylor_johnson.realsocialnew.Model.Options;
import com.taylor_johnson.realsocialnew.R;
import com.taylor_johnson.realsocialnew.View.AgreementActivity;
import com.taylor_johnson.realsocialnew.View.NoticeActivity;
import com.taylor_johnson.realsocialnew.View.Poll;
import com.taylor_johnson.realsocialnew.View.ServiceClientActivity;
import com.taylor_johnson.realsocialnew.View.SimulateActivity;
import com.taylor_johnson.realsocialnew.View.SocialActivity;
import com.taylor_johnson.realsocialnew.View.TurnActivity;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemClickListener  {

    private AdapterRecyclerView adapter;
    private RecyclerView recycler;
    //private LinearLayoutManager layoutManager;
    private GridLayoutManager layoutManager;
    private Boolean flagMultiRed;
    private int itemId;
    List<Options> items=new ArrayList<>();
    private Context context;
    private List<OpcionesResult> temp;
    OnItemClickListener tmp;
    private ImageButton multiredbtn, bancabtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.pictureRecycler);
        multiredbtn=(ImageButton)findViewById(R.id.imgbtnmultired);
        bancabtn=(ImageButton)findViewById(R.id.imgbtnbanca);
        layoutManager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(layoutManager);
        context = this;
        tmp = this;
        if (!connectInternet()) {
            Toast.makeText(this, "Verifique su conexion a internet", Toast.LENGTH_SHORT).show();


        }


        //cambios de la app para el butom bar en todas las app se debe modificar el valor bottombar_heigt
        //en dimens para no quede por encima el recyclerview att JFQ.

        multiredbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                if (packageManager.getLaunchIntentForPackage("mcsoft.multired") != null) {
                    Toast.makeText(getApplicationContext(), "Gracias por utilizar los servicios de Multi Red!", Toast.LENGTH_SHORT).show();
                    startActivity(packageManager.getLaunchIntentForPackage("mcsoft.multired"));
                } else {
                    Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=mcsoft.multired&hl=es");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(webIntent);
                }

            }
        });
        bancabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager packageManager = getPackageManager();
                if (packageManager.getLaunchIntentForPackage("com.taylorandjohnson.appbancamovil") != null) {
                    Toast.makeText(getApplicationContext(), "Gracias por utilizar los servicios de la Banca Movil!", Toast.LENGTH_SHORT).show();
                    startActivity(packageManager.getLaunchIntentForPackage("com.taylorandjohnson.appbancamovil"));
                } else {
                    Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=com.taylorandjohnson.appbancamovil&hl=es");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(webIntent);
                }

            }
        });


/*
        //comfiguracion de intents para lanzar la aplicacion de multired  o la banca movil
        BottomBar bottomBar=(BottomBar) findViewById(R.id.bottombar);
        //bottomBar.setDefaultTab(R.id.pagar);
        flagMultiRed = false;
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    //cobrar
                    case R.id.pagar:
                        PackageManager packageManager = getPackageManager();
                        if (packageManager.getLaunchIntentForPackage("mcsoft.multired") != null) {
                            if(flagMultiRed){
                                Toast.makeText(getApplicationContext(), "Gracias por utilizar los servicios de Multi Red!", Toast.LENGTH_SHORT).show();
                                startActivity(packageManager.getLaunchIntentForPackage("mcsoft.multired"));

                            }else{
                                flagMultiRed = true;
                            }
                        } else {
                            if (flagMultiRed) {
                                Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=mcsoft.multired&hl=es_419");
                                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                                startActivity(webIntent);
                            } else {
                                flagMultiRed = true;
                            }
                        }
                        break;
                    case R.id.cobrar:
                        packageManager = getPackageManager();
                        try{
                            if (packageManager.getLaunchIntentForPackage("com.taylorandjohnson.appbancamovil") != null) {
                                if(flagMultiRed){
                                    Toast.makeText(getApplicationContext(), "Gracias por utilizar los servicios de Banca móvil!", Toast.LENGTH_SHORT).show();
                                    startActivity(packageManager.getLaunchIntentForPackage("com.taylorandjohnson.appbancamovil"));

                                }else{
                                    flagMultiRed = true;
                                }
                            } else {
                                if (flagMultiRed) {
                                    Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=com.taylorandjohnson.appbancamovil&rdid=com.taylorandjohnson.appbancamovil");
                                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                                    startActivity(webIntent);
                                } else {
                                    flagMultiRed = true;
                                }
                            }}
                        catch (Exception e){}
                        break;
                }
            }
        });*/
        getOptions();
    }

    private void getOptions() {
        final ProgressDialog loading = ProgressDialog.show(this, "Cargando", "Please wait...", false, false);
        try{
            RealsocialService service= RealsocialClient.getRealsocialClient().create(RealsocialService.class);
            Call<OptionsApiResponse> call=service.getOptionList();
            call.enqueue(new Callback<OptionsApiResponse>() {
                @Override
                public void onResponse(Call<OptionsApiResponse> call, Response<OptionsApiResponse> response) {
                    OptionsApiResponse rowListItem=response.body();
                    if(rowListItem != null){
                        loading.dismiss();

                        for(int i=0;i<rowListItem.getOpcionesResult().size();i++){
                            items.add(new Options(
                                    rowListItem.getOpcionesResult().get(i).getID(),
                                    rowListItem.getOpcionesResult().get(i).getCodigo(),
                                    rowListItem.getOpcionesResult().get(i).getNombre()
                            ));
                        }
                        temp = rowListItem.getOpcionesResult();
                        adapter=new AdapterRecyclerView(temp, tmp);
                        recycler.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<OptionsApiResponse> call, Throwable t) {

                }
            });
        }catch (Exception e){}
    }

    @Override
    public void onClick(int itemId ) {
        //Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();


        itemId=Integer.parseInt(String.valueOf(items.get(itemId).getCode()));
        if(itemId==2){
            Intent i = new Intent(this, NoticeActivity.class);
            startActivity(i);
        }
        if(itemId==5){
            Intent i = new Intent(this, AgreementActivity.class);
            startActivity(i);
        }
        if(itemId==3){
            Intent i = new Intent(this, SocialActivity.class);
            startActivity(i);
        }
        if(itemId==4){
            Intent i = new Intent(this, ServiceClientActivity.class);
            startActivity(i);
        }

        if(itemId==1){
            Intent i = new Intent(this, TurnActivity.class);
            startActivity(i);
        }
        if(itemId==6){
            Intent i = new Intent(this, Poll.class);
            startActivity(i);
        }
        if(itemId==0){
            Intent i = new Intent(this, SimulateActivity.class);
            startActivity(i);
        }

        if(itemId==7){


            Toast.makeText(this," opcion en construción",Toast.LENGTH_LONG).show();
        }

    }

    public boolean connectInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }else{
            return false;
        }
    }




}
