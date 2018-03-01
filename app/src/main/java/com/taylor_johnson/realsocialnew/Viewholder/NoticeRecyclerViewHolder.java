package com.taylor_johnson.realsocialnew.Viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taylor_johnson.realsocialnew.R;

/**
 * Created by desarrolladorjf on 24/03/2017.
 */

public class NoticeRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView descripcion;
    public TextView link;
    public TextView titulo;
    public ImageView imagen;



    public NoticeRecyclerViewHolder(View itemView) {

        super(itemView);

        itemView.setOnClickListener(this);



        //textTittle,textContentImage,picture_cardNotice
        descripcion=(TextView)itemView.findViewById(R.id.textContent_notice);

       titulo=(TextView) itemView.findViewById(R.id.textContent_notice);

       imagen=(ImageView)itemView.findViewById(R.id.picture_cardNotice);



    }

    @Override
    public void onClick(View v) {

    }

}
