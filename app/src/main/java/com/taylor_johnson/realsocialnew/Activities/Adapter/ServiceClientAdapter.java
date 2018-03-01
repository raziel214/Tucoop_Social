package com.taylor_johnson.realsocialnew.Activities.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Api.OficinasResult;

import com.taylor_johnson.realsocialnew.R;
//import com.taylor_johnson.realsocialnew.View.Base.ImageLoader;
import com.taylor_johnson.realsocialnew.Viewholder.RecyclerViewHolder;

import java.util.List;

/**
 * Created by desarrolladorjf on 22/03/2017.
 */

public class ServiceClientAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<OficinasResult> itemList1;
    private OnItemClickListener clickListener;

    public ServiceClientAdapter(List<OficinasResult> itemList1, OnItemClickListener clickListener) {
        this.itemList1 = itemList1;
        this.clickListener = clickListener;
    }




    //ImageLoader imageLoader;




    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_service,parent, false);

        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder,final int position) {
        //holder.imagen.setText(itemList1.get(position).getCiudad());
        holder.nombre.setText(itemList1.get(position).getNombre());
        holder.tipo.setText(itemList1.get(position).getTipo());
        Picasso.with(holder.imagen.getContext()).load(itemList1.get(position).getImagen()).into(holder.imagen);

        holder.imagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (clickListener != null){
                    clickListener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return this.itemList1.size();
    }


}
