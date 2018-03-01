package com.taylor_johnson.realsocialnew.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.NoticeAdapterRecyclerView;
import com.taylor_johnson.realsocialnew.Api.NoticeApiResponse;
import com.taylor_johnson.realsocialnew.Api.NoticiasResult;
import com.taylor_johnson.realsocialnew.Api.RealsocialClient;
import com.taylor_johnson.realsocialnew.Api.RealsocialService;
import com.taylor_johnson.realsocialnew.Model.Notice;
import com.taylor_johnson.realsocialnew.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recycler;
    private NoticeAdapterRecyclerView adapter;
    private LinearLayoutManager layoutManager;
    List<Notice> items=new ArrayList<>();
    private Context context;
    private List<NoticiasResult> temp;
    private OnItemClickListener tmp;
    public int []itemId3=new int[30];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        showToolbar(getResources().getString(R.string.toolbar_tittle_Notice), true);

        recycler=(RecyclerView)findViewById(R.id.pictureRecycler_notice);
        layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        context = this;
        tmp = this;

        getNotice();

    }

    private void getNotice(){


        try{

            RealsocialService service=RealsocialClient.getRealsocialClient().create(RealsocialService.class);

            Call<NoticeApiResponse> call=service.getNoticePostList();

            call.enqueue(new Callback<NoticeApiResponse>() {
                @Override
                public void onResponse(Call<NoticeApiResponse> call, Response<NoticeApiResponse> response) {

                    NoticeApiResponse rowListItem=response.body();

                    if(rowListItem != null){



                        for(int i=0;i<rowListItem.getNoticiasResult().size();i++){
                            items.add(new Notice(
                                    rowListItem.getNoticiasResult().get(i).getID(),
                                    rowListItem.getNoticiasResult().get(i).getLink(),
                                    rowListItem.getNoticiasResult().get(i).getImagen(),
                                    rowListItem.getNoticiasResult().get(i).getTitulo()));

                            itemId3[i]=Integer.parseInt(String.valueOf(items.get(i).getID()));
                        }




                        adapter=new NoticeAdapterRecyclerView(rowListItem.getNoticiasResult(),tmp);
                        recycler.setAdapter(adapter);

                        /* adapter=new SocialAdapterRecyclerView(rowListItem.getRedesSocialesResult(),tmp);
                        recycler.setAdapter(adapter);*/

                    }

                }

                @Override
                public void onFailure(Call<NoticeApiResponse> call, Throwable t) {

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

        //se verifica el evento Onclick con esta funcion
        //Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();
        //se trae la url pero se debe revisar comollega la Url
        String itemId2=String.valueOf(items.get(itemId).getActivo());
        itemId=Integer.parseInt(String.valueOf(items.get(itemId).getID()));

        for(int i=0;i<itemId3.length;i++) {
            if(itemId3[i]==itemId){
                try {
                    Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                catch (Exception e){

                    Toast.makeText(getApplicationContext(), "Url no disponible  " , Toast.LENGTH_LONG).show();

                }
            }


        }






/*

        if (itemId==0){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

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
        if (itemId==4){
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
        if (itemId==10){
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
