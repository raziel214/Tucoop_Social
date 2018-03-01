package com.taylor_johnson.realsocialnew.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taylor_johnson.realsocialnew.R;

/**
 * Created by desarrolladorjf on 3/04/2017.
 */

public class ServiceClientViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView descripcion;
    public TextView fecha;
    public TextView empresa;
    public TextView horario;
    public ImageView imagen;
    public TextView link;
    public TextView tipo;

    public ServiceClientViewholder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        empresa=(TextView)itemView.findViewById(R.id.textNombre);
        imagen= (ImageView) itemView.findViewById(R.id.picture_CardService);
        tipo=(TextView) itemView.findViewById(R.id.textTipo);



    }


    @Override
    public void onClick(View v) {

    }
}
