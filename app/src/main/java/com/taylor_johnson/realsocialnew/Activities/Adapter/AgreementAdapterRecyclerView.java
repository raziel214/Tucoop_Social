package com.taylor_johnson.realsocialnew.Activities.Adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Api.ConveniosResult;
import com.taylor_johnson.realsocialnew.Model.Agreement.Agreement;
import com.taylor_johnson.realsocialnew.R;
import com.taylor_johnson.realsocialnew.Viewholder.AgreementRecyclerViewHolder;

import java.util.List;

/**
 * Created by desarrolladorjf on 22/02/2017.
 */

public class AgreementAdapterRecyclerView extends RecyclerView.Adapter<AgreementRecyclerViewHolder>{

    private List<ConveniosResult> itemList5;
    private OnItemClickListener clickListener;

    public AgreementAdapterRecyclerView(List<ConveniosResult> itemList5,OnItemClickListener listener) {
        this.itemList5 = itemList5;
        this.clickListener=listener;
    }

    @Override
    public AgreementRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_agreement,parent, false);

        AgreementRecyclerViewHolder agreementRecyclerViewHolder=new AgreementRecyclerViewHolder(view);

        return agreementRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(AgreementRecyclerViewHolder holder,final int position) {

        holder.descripcion.setText(itemList5.get(position).getDescripcion());
        holder.titulo.setText(itemList5.get(position).getTitulo());
        Picasso.with(holder.imagen.getContext()).load(itemList5.get(position).getImagen()).into(holder.imagen);

        // para que funcione el evento Onclick

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
        return itemList5.size();
    }
}
