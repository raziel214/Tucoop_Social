package com.taylor_johnson.realsocialnew.View;

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
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListenerRedes;
import com.taylor_johnson.realsocialnew.Api.RealsocialClient;
import com.taylor_johnson.realsocialnew.Api.RealsocialService;
import com.taylor_johnson.realsocialnew.Api.RedesSocialesResult;
import com.taylor_johnson.realsocialnew.Api.SocialApiResponse;
import com.taylor_johnson.realsocialnew.Model.Social;
import com.taylor_johnson.realsocialnew.Activities.Adapter.SocialAdapterRecyclerView;
import com.taylor_johnson.realsocialnew.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SocialActivity extends AppCompatActivity implements OnItemClickListenerRedes {
    private RecyclerView recycler;
    private SocialAdapterRecyclerView adapter;
    private LinearLayoutManager layoutManager;
    List<Social> items=new ArrayList<>();
    private Context context;
    private List<RedesSocialesResult> temp;
    private OnItemClickListenerRedes tmp;

   // private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        showToolbar(getResources().getString(R.string.toolbar_tittle_Social), true);
        recycler=(RecyclerView) findViewById(R.id.social_Recycler);
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        context = this;
        tmp = this;





//        // Inicializar PictureConve
//        List<Social> items4 = new ArrayList<>();
//
//        //pasar imagenes del web service
//
//        items4.add(new Social(R.drawable.facebook));
//        items4.add(new Social(R.drawable.skype));
//        items4.add(new Social(R.drawable.youtube));
//        items4.add(new Social(R.drawable.tiwtter));
//
//        // Obtener el Recycler
//        recycler = (RecyclerView) findViewById(R.id.social_Recycler);
//        recycler.setHasFixedSize(true);
//
//        // Usar un administrador para LinearLayout
//        lManager = new LinearLayoutManager(this);
//        recycler.setLayoutManager(lManager);
//
//        // Crear un nuevo adaptador
//        // Se le pasa la Activity porque implementa la interfaz OnItemClickListener, para ejecutar el metodo OnClick del Activity desde el adapter
//        adapter = new SocialAdapterRecyclerView(items4);
//        recycler.setAdapter(adapter);


        getSocial();

    }


    private void getSocial() {

        try{

            RealsocialService service= RealsocialClient.getRealsocialClient().create(RealsocialService.class);
            Call<SocialApiResponse> call=service.getSociaList();

            call.enqueue(new Callback<SocialApiResponse>() {
                @Override
                public void onResponse(Call<SocialApiResponse> call, Response<SocialApiResponse> response) {
                    SocialApiResponse rowListItem=response.body();
                    if (rowListItem != null){

                        for(int i=0;i<rowListItem.getRedesSocialesResult().size();i++){
                            items.add(new Social(
                                    rowListItem.getRedesSocialesResult().get(i).getID(),
                                    rowListItem.getRedesSocialesResult().get(i).getLink(),
                                    rowListItem.getRedesSocialesResult().get(i).getImagen()));

                        }

                        //temp = rowListItem.getRedesSocialesResult();
                        adapter=new SocialAdapterRecyclerView(rowListItem.getRedesSocialesResult(),tmp);
                        recycler.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<SocialApiResponse> call, Throwable t) {

                }
            });

        }
        catch(Exception e){}

    }



    @Override
    public void onClick(int itemId) {
        String itemId2=String.valueOf(items.get(itemId).getCode());
        //Toast.makeText(this, "" + itemId, Toast.LENGTH_SHORT).show();

        if (itemId==0){
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
        if (itemId==4){
            Uri uri = Uri.parse(itemId2); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }



//        Uri uri = Uri.parse();
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);



    }

    private void showToolbar(String tittle, boolean upButton) {

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

//    @Override
//    public void onClick(View v) {
//
//        Toast.makeText(this, "" , Toast.LENGTH_SHORT).show();
//
//    }

    /* de esta manera se declara el onback button en el manifest
   relacionar en la actividad hijo la actividad padre
   <activity android:name=".View.Poll"
            android:parentActivityName=".Activities.MainActivity"
            >
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Activities.MainActivity"/>

        </activity>


    }*/
}
