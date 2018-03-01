package com.taylor_johnson.realsocialnew.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taylor_johnson.realsocialnew.R;

/**
 * Created by desarrolladorjf on 24/03/2017.
 */

public class AgreementRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //public TextView descripcion;
    public TextView descripcion;
    public TextView fecha;
    public TextView empresa;
    public TextView horario;
    public ImageView imagen;
    public TextView link;
    public TextView titulo;


    public AgreementRecyclerViewHolder(View itemView) {

        super(itemView);

        itemView.setOnClickListener(this);
        // espera....
        descripcion=(TextView) itemView.findViewById(R.id.textContentImage);

        titulo=(TextView) itemView.findViewById(R.id.agreement_card);



        imagen=(ImageView) itemView.findViewById(R.id.picture_CardAgreement);

    }



    @Override
    public void onClick(View v) {

    }

}
