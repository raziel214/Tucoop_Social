package com.taylor_johnson.realsocialnew.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListenerRedes;
import com.taylor_johnson.realsocialnew.Activities.Adapter.SocialAdapterRecyclerView;
import com.taylor_johnson.realsocialnew.Api.RedesSocialesResult;
import com.taylor_johnson.realsocialnew.R;

import java.util.List;

/**
 * Created by desarrolladorjf on 31/03/2017.
 */

public class SocialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
public TextView descripcion;
public TextView fecha;
public TextView empresa;
public TextView horario;
public ImageView imagen;
public TextView link;
public TextView titulo;

    public SocialViewHolder(View itemView) {

        super(itemView);
        itemView.setOnClickListener(this);
        titulo=(TextView) itemView.findViewById(R.id.tittle_social);
        imagen=(ImageView)itemView.findViewById(R.id.picture_CardSocial);
    }


    @Override
    public void onClick(View v) {

    }
}
