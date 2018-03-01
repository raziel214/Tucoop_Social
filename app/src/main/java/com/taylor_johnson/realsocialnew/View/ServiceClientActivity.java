package com.taylor_johnson.realsocialnew.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.ServiceClientAdapter;
import com.taylor_johnson.realsocialnew.Api.OfficeApiResponse;
import com.taylor_johnson.realsocialnew.Api.RealsocialClient;
import com.taylor_johnson.realsocialnew.Api.RealsocialService;
import com.taylor_johnson.realsocialnew.Api.ServiceClientResult;
import com.taylor_johnson.realsocialnew.Model.ServiceClient;
import com.taylor_johnson.realsocialnew.Model.Social;
import com.taylor_johnson.realsocialnew.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceClientActivity extends AppCompatActivity implements OnItemClickListener{
    private RecyclerView recycler;
    private ServiceClientAdapter adapter;
    List<ServiceClient> items=new ArrayList<>();
    private Context context;
    private List<ServiceClientResult> temp;
    private OnItemClickListener tmp;
    private LinearLayoutManager layoutManager;
    public int []itemId2=new int[20];

    private Activity activity;
    private String consumo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_client);
        showToolbar(getResources().getString(R.string.toolbar_tittle_service), true);



        recycler=(RecyclerView)findViewById(R.id.pictureRecycler_Service);
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        context = this;
        tmp = this;

        getOfficen();





    }

    private void getOfficen(){

        try{
            RealsocialService service= RealsocialClient.getRealsocialClient().create(RealsocialService.class);
            Call <OfficeApiResponse> call=service.getPostList();


            call.enqueue(new Callback<OfficeApiResponse>() {
                @Override
                public void onResponse(Call<OfficeApiResponse> call, Response<OfficeApiResponse> response) {

                    OfficeApiResponse rowListItem=response.body();
                    if (rowListItem != null){



                        for(int i=0;i<rowListItem.getOficinasResult().size();i++){

                            items.add(new ServiceClient(
                                    rowListItem.getOficinasResult().get(i).getID(),
                                    rowListItem.getOficinasResult().get(i).getCoordenadas(),
                                    rowListItem.getOficinasResult().get(i).getImagen(),
                                    rowListItem.getOficinasResult().get(i).getHorario(),
                                    rowListItem.getOficinasResult().get(i).getCiudad(),
                                    rowListItem.getOficinasResult().get(i).getNombre(),
                                    rowListItem.getOficinasResult().get(i).getTelefono(),
                                    rowListItem.getOficinasResult().get(i).getTipo(),
                                    rowListItem.getOficinasResult().get(i).getNombre(),
                                    rowListItem.getOficinasResult().get(i).getDireccion()));


                            itemId2[i]= Integer.parseInt(String.valueOf(items.get(i).getId()));
                            consumo=String.valueOf(items.get(i).getTipo());



                        }



                        adapter=new ServiceClientAdapter(rowListItem.getOficinasResult(),tmp);
                        recycler.setAdapter(adapter);
                    }


                }

                @Override
                public void onFailure(Call<OfficeApiResponse> call, Throwable t) {

                }
            });


        }catch (Exception e){

        }


    }

    @Override
    public void onClick( int itemId) {
         String items3;
         String items4;
         String items5;
         String items6;
         String items7;
         String items8;
         String items9;
        items3=items.get(itemId).getNombre();
        items4=items.get(itemId).getDireccion();
        items5=items.get(itemId).getTipo();
        items6=items.get(itemId).getHorario();
        items7=items.get(itemId).getImagen();
        items8=items.get(itemId).getTelefono();
        items9=items.get(itemId).getCoordenadas();
        //sentencia para evaluar todos los valores de itemid con la lista de id del servicio
        //Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();


        itemId=Integer.parseInt(String.valueOf(items.get(itemId).getId()));


            for(int i=0;i<itemId2.length;i++) {
                if ( itemId2[i]==itemId) {

                    try {
                        Intent j = new Intent(this, OfficeDetailActivity.class);
                        j.putExtra(OfficeDetailActivity.nombretext,items3);
                        j.putExtra(OfficeDetailActivity.direciontext,items4);
                        j.putExtra(OfficeDetailActivity.tipotext,items5);
                        j.putExtra(OfficeDetailActivity.horariotext,items6);
                        j.putExtra(OfficeDetailActivity.imagensUrl,items7);
                        j.putExtra(OfficeDetailActivity.telefonotext,items8);
                        j.putExtra(OfficeDetailActivity.coordenada,items9);
                        startActivity(j);

                    }catch (Exception e){

                        Toast.makeText(getApplicationContext(), "Por Favor revisar  " + e.getMessage(), Toast.LENGTH_LONG).show();

                    }


                }
            }







    }






    private void showToolbar(String tittle, boolean upButton) {

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


    /* de esta manera se declara el onback button en el manifest
   relacionar en la actividad hijo la actividad padre
   <activity android:name=".View.ServiceClienttActivity"
            android:parentActivityName=".Activities.MainActivity"
            >
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Activities.MainActivity"/>

        </activity>


    }*/


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
