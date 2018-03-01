package com.taylor_johnson.realsocialnew.Activities.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListenerRedes;
import com.taylor_johnson.realsocialnew.Api.RedesSocialesResult;
import com.taylor_johnson.realsocialnew.Api.ServiceClientResult;
import com.taylor_johnson.realsocialnew.Model.Social;
import com.taylor_johnson.realsocialnew.R;
import com.taylor_johnson.realsocialnew.View.SocialActivity;
import com.taylor_johnson.realsocialnew.Viewholder.SocialViewHolder;

import java.util.List;

/**
 * Created by desarrolladorjf on 27/02/2017.
 *
 Produced by taylor and johnson
 */

public class SocialAdapterRecyclerView extends RecyclerView.Adapter<SocialViewHolder> {

        private List<RedesSocialesResult> items4;
        private OnItemClickListenerRedes clickListener;



    public SocialAdapterRecyclerView(List<RedesSocialesResult> items4,OnItemClickListenerRedes listener) {
        //variable de click
        this.items4 = items4;
        this.clickListener = listener;
    }

    @Override
    public SocialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_social,parent,false);

        SocialViewHolder socialViewHolder=new SocialViewHolder(view);
        return socialViewHolder;
    }

    @Override
    public void onBindViewHolder(SocialViewHolder holder, final int position) {

        holder.titulo.setText(items4.get(position).getNombre());
        Picasso.with(holder.imagen.getContext()).load(items4.get(position).getImagen()).into(holder.imagen);

        //s
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
        return items4.size();
    }


//        public static class SocialViewHolder extends RecyclerView.ViewHolder {
//
//            public ImageView Picture ;
//            public SocialViewHolder(View v) {
//                super(v);
//                //llamar la image view de el layout en el card view de Agreement_card
//                Picture = (ImageView) v.findViewById(R.id.picture_CardSocial);
//
//            }
//        }
//
//
//
//
//    public SocialAdapterRecyclerView(List<Social> items4) {
//        this.items4 = items4;
//    }
//
//    @Override
//    public int getItemCount() {
//        return items4.size();
//    }
//
//
//    /*Se infla la tarjeta a manejar en el recycler view  */
//
//    @Override
//    public SocialViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View v = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.cardview_social, viewGroup, false);
//        return new SocialViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(SocialViewHolder viewHolder, int position) {
//
//        viewHolder.Picture.setImageResource(items4.get(position).getSocial());
//
//
//    }





















}
