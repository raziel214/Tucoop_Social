package com.taylor_johnson.realsocialnew.Viewholder;

import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taylor_johnson.realsocialnew.R;

/**
 * Created by desarrolladorjf on 30/03/2017.
 */

public class OptionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public int ID;
    public ImageView imagen;
    public TextView number;

    public OptionsViewHolder(View itemView){
        super(itemView);
        itemView.setOnClickListener(this);
        ID=0;
        imagen=(ImageView) itemView.findViewById(R.id.picture_Card);
        number=(TextView) itemView.findViewById(R.id.number_id);
        System.out.print("aqui estoy");
    }

    @Override
    public void onClick(View v) {
        System.out.print("aqui no estoy");
    }
}
