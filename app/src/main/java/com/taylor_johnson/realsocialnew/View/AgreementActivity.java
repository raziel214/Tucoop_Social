package com.taylor_johnson.realsocialnew.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.taylor_johnson.realsocialnew.Activities.Adapter.AgreementAdapterRecyclerView;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListenerRedes;
import com.taylor_johnson.realsocialnew.Api.AgreementApiResponse;
import com.taylor_johnson.realsocialnew.Api.ConveniosResult;
import com.taylor_johnson.realsocialnew.Api.RealsocialClient;
import com.taylor_johnson.realsocialnew.Api.RealsocialService;
import com.taylor_johnson.realsocialnew.Model.Agreement.Agreement;
import com.taylor_johnson.realsocialnew.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgreementActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recycler;
    private AgreementAdapterRecyclerView adapter;
    List<Agreement> items=new ArrayList<>();
    private Context context;
    private List<ConveniosResult> temp;
    private OnItemClickListener tmp;
    public int []itemId3=new int[30];

    //private RecyclerView.LayoutManager lManager;
    //private Activity activity;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        showToolbar(getResources().getString(R.string.toolbar_tittle), true);
        recycler = (RecyclerView) findViewById(R.id.pictureRecycler_Agreetmen);
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        context = this;
        tmp = this;


        getAgreement();

    }

    private void getAgreement() {

        try{
            RealsocialService service= RealsocialClient.getRealsocialClient().create(RealsocialService.class);

            Call<AgreementApiResponse> call=service.getAgreementList();

            call.enqueue(new Callback<AgreementApiResponse>() {
                @Override
                public void onResponse(Call<AgreementApiResponse> call, Response<AgreementApiResponse> response) {

                    AgreementApiResponse rowListItem=response.body();

                    if (rowListItem != null){


                        for(int i=0;i<rowListItem.getConveniosResult().size();i++){

                            items.add(new Agreement(
                                    rowListItem.getConveniosResult().get(i).getID(),
                                    rowListItem.getConveniosResult().get(i).getImagen(),
                                    rowListItem.getConveniosResult().get(i).getLink()));
                            itemId3[i]=Integer.parseInt(String.valueOf(items.get(i).getAgreement()));

                        }


                        adapter=new AgreementAdapterRecyclerView(rowListItem.getConveniosResult(),tmp);
                        recycler.setAdapter(adapter);
                    }

                }

                @Override
                public void onFailure(Call<AgreementApiResponse> call, Throwable t) {

                }
            });
        }
        catch (Exception e){

        }
    }

    private void showToolbar(String tittle, boolean upButton) {

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public void onClick(int itemId) {



        // Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();
        String itemId2=String.valueOf(items.get(itemId).getName());
        itemId=Integer.parseInt(String.valueOf(items.get(itemId).getAgreement()));

        for(int i=0;i<itemId3.length;i++) {
            if(itemId3[i]==itemId) {
                try {
                    Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Url no disponible  ", Toast.LENGTH_LONG).show();

                }
            }


        }


        /*if (itemId==0){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            //Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();
        }
        if (itemId==1){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);


        }
        if (itemId==2){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
        if (itemId==3){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if (itemId==5){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
        if (itemId==6){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
        if (itemId==7){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
        if (itemId==8){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
        if (itemId==9){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }
*/





    }

   /* de esta manera se declara el onback button en el manifest
   relacionar en la actividad hijo la actividad padre
   activity android:name=".View.AgreementActivity"
            android:parentActivityName=".Activities.MainActivity"
            >
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Activities.MainActivity"/>

        </activity>


    }*/


}
