package com.taylor_johnson.realsocialnew.Activities.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Api.OpcionesResult;
import com.taylor_johnson.realsocialnew.Model.Picture;
import com.taylor_johnson.realsocialnew.R;
import com.taylor_johnson.realsocialnew.Viewholder.OptionsViewHolder;

import java.util.List;

/**
 * Created by desarrolladorjf on 21/02/2017.
 */

public class AdapterRecyclerView extends RecyclerView.Adapter<OptionsViewHolder> {

    Context context;
    private OnItemClickListener clickListener;
    private List<OpcionesResult> items;
    private Activity activity;

    public AdapterRecyclerView(List<OpcionesResult> items, OnItemClickListener listener) {
        this.items = items;
        this.clickListener = listener;
    }

    public AdapterRecyclerView(List<OpcionesResult> items) {
        this.items=items;
    }

    @Override
    public OptionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_picture,parent,false);
        OptionsViewHolder adapterRecyclerView=new OptionsViewHolder( view);
        return adapterRecyclerView;
    }

    @Override
    public void onBindViewHolder(OptionsViewHolder holder, final int position) {
        //Picasso.with(holder.imagen.getContext()).load(items.get(position).getID()).into(holder.imagen);
        holder.number.setText(items.get(position).getCodigo());
//        switch (items.get(position).getCodigo()) {
//            case "1":
//                holder.imagen.setImageResource(R.drawable.agreements);
//                break;
//            case "2":
//                holder.imagen.setImageResource(R.drawable.poll);
//                break;
//        }
        if(2== Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.notice);
        }
        if(5== Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.agreements);
        }
        if(3== Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.social);
        }
        if(4== Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.service);
        }
        if(1==Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.turn);
        }
        if(6== Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.poll);
        }
        if(0==Integer.parseInt(items.get(position).getCodigo())){
            holder.imagen.setImageResource(R.drawable.simulador);
        }
        if(7== Integer.parseInt(items.get(position).getCodigo())){
            //holder.imagen.setImageResource(R.drawable.);
        }
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
    public int getItemCount() {
        return items.size();
    }


//    public static  class PictureViewHolder extends RecyclerView.ViewHolder
//    {
//        // Campos respectivos de un item
//        //private ImageView pictureCard;
//        private View view;
//        public ImageView Picture;
//        public PictureViewHolder(View v) {
//            super(v);
//            //llamar el layout de la card
//            Picture = (ImageView) v.findViewById(R.id.picture_Card);
//            this.view = view;
//        }
//
//
//
//    }


//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//
//    @Override
//    public PictureViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View v = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.cardview_picture, viewGroup, false);
//        return new PictureViewHolder(v);
//
//    }
//
//    @Override
//    public void onBindViewHolder(PictureViewHolder viewHolder, final int position) {
//
//        // Como el Click listener es la activity que le pasamos por constructor, va a ejecutar el metodo OnClick del Activity.
//        // RUN!!!!!
//
//        viewHolder.Picture.setImageResource(items.get(position).getID());
//
//        viewHolder.Picture.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//
//                if (clickListener != null){
//
//                    clickListener.onClick(position);
//                }
//            }
//        });
//
//
//    }

}
