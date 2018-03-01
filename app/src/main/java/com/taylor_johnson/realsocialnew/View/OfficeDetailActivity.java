package com.taylor_johnson.realsocialnew.View;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Model.ServiceClient;
import com.taylor_johnson.realsocialnew.R;

import java.util.ArrayList;
import java.util.List;

import static com.taylor_johnson.realsocialnew.R.id.picture_Office;

public class OfficeDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    public GoogleMap gmap;
    private MapFragment map;
    private static final int LOCATION_REQUEST_CODE = 1;
    public static String nombretext="nombre";
    public static String direciontext="dirección";
    public static String imagensUrl="imagen";
    public static String horariotext="horario";
    public static String horariotext1="Horario de atención";
    public static String telefonotext="teléfono";
    public static String telefonotext1="teléfono";
    public static String detailtext="detalle";
    public static String direciontext1="Dirección:";
    public static String tipotext="tipo";
    public static String tipotext1="Tipo";
    public static String coordenada="";
    private TextView nombre;
    private TextView direccion;
    private ImageView imagens;
    private TextView horario;
    private TextView horario1;
    private TextView telefono;
    private TextView telefono1;
    private TextView direcion1;
    private TextView tipo1;
    private TextView tipo;
    private ImageButton btn_llamar;
    public String number;
    public String coor;
    public char prb;

    private ServiceClient detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_detail);

        detail=new ServiceClient();
        map = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        map.getMapAsync(this);
        nombre=(TextView)findViewById(R.id.textNombreSucursal);
        imagens=(ImageView)findViewById(R.id.picture_Office);
        direccion=(TextView)findViewById(R.id.textDirecccion);
        horario=(TextView)findViewById(R.id.textHorario);
        horario1=(TextView)findViewById(R.id.textHorario1);
        telefono=(TextView)findViewById(R.id.textTelefono1);
        telefono1=(TextView)findViewById(R.id.textTelefono);
        direcion1=(TextView)findViewById(R.id.textDirecccion1);
        tipo=(TextView)findViewById(R.id.serviceTextTipo1);
        tipo1=(TextView)findViewById(R.id.serviceTextTipo);
        btn_llamar=(ImageButton)findViewById(R.id.callImageButton);






        nombre.setText(getIntent().getStringExtra(nombretext));
        direccion.setText(getIntent().getStringExtra(direciontext));
        direcion1.setText(direciontext1);
        horario1.setText(horariotext1);
        horario.setText(getIntent().getStringExtra(horariotext));
        tipo.setText(getIntent().getStringExtra(tipotext));
        tipo1.setText(tipotext1);
        Picasso.with(this).load(getIntent().getStringExtra(imagensUrl)).into(imagens);
        telefono.setText(getIntent().getStringExtra(telefonotext));
        telefono1.setText(telefonotext1);


        number=getIntent().getStringExtra(telefonotext);
        coor=getIntent().getStringExtra(coordenada);


        addListenerOnButton();







    }

    private  void addListenerOnButton(){



        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detail!=null){
                    String number5= String.valueOf(0);
                    String number6= String.valueOf(3);

                    String number2=number5+number6+number.substring(0, number.length());
                        Log.w("Number",number2);
                        Intent callIntent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number2));
                        startActivity(callIntent);

                }

            }
        });



    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;

        Float[] coords = convertirCoordenadas(coor);
        Log.i("COORDS", googleMap.toString());
        LatLng latLng = new LatLng(coords[0],coords[1]);
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(coor).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

        setUpMap();

    }
    private Float[] convertirCoordenadas(String coordenadas) {
        Float[] coords = new Float[2];
        coords[0] = Float.parseFloat(coordenadas.substring(0, coordenadas.indexOf(",")));
        coords[1] = Float.parseFloat(coordenadas.substring(coordenadas.indexOf(",")+1));
        return coords;
    }
    public void setUpMap() {

        gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {


            }else{

                ActivityCompat.requestPermissions(
                        this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE);
            }

        }else{
            gmap.setMyLocationEnabled(true);
        }



        gmap.getUiSettings().isCompassEnabled();
        gmap.getUiSettings().setMapToolbarEnabled(true);
        gmap.getUiSettings().setZoomControlsEnabled(true);
        gmap.setIndoorEnabled(true);
        gmap.setBuildingsEnabled(true);

    }


}
