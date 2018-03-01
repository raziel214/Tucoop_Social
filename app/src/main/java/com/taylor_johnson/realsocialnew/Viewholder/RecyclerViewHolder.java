package com.taylor_johnson.realsocialnew.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taylor_johnson.realsocialnew.R;

/**
 * Created by desarrolladorjf on 22/03/2017.
 */



public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView ciudad;
        public TextView coordenadas;
        public TextView direccion;
        public TextView empresa;
        public TextView horario;
        public ImageView imagen;
        public TextView nombre;
        public TextView telefono;
        public TextView tipo;







        public RecyclerViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
                nombre=(TextView) itemView.findViewById(R.id.textNombre);
                imagen=(ImageView) itemView.findViewById(R.id.picture_CardService);
                tipo=(TextView)itemView.findViewById(R.id.textTipo);
        }



        @Override
        public void onClick(View v) {

        }
    }


