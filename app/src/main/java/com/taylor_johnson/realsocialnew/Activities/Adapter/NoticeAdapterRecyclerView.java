package com.taylor_johnson.realsocialnew.Activities.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListener;
import com.taylor_johnson.realsocialnew.Activities.Adapter.Interface.OnItemClickListenerRedes;
import com.taylor_johnson.realsocialnew.Api.NoticeResult;
import com.taylor_johnson.realsocialnew.Api.NoticiasResult;
import com.taylor_johnson.realsocialnew.Model.Notice;
import com.taylor_johnson.realsocialnew.R;
import com.taylor_johnson.realsocialnew.Viewholder.NoticeRecyclerViewHolder;

import java.util.List;

/**
 * Created by desarrolladorjf on 24/02/2017.
 */

public class NoticeAdapterRecyclerView extends RecyclerView.Adapter<NoticeRecyclerViewHolder> {

    private List<NoticiasResult> itemList3;
    private OnItemClickListener clickListener;

    public NoticeAdapterRecyclerView(List<NoticiasResult> itemList3,OnItemClickListener listener) {
        this.itemList3 = itemList3;
        this.clickListener = listener;
    }



    @Override
    public NoticeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_notice,parent,false);
      //View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_agreement,parent, false);

        NoticeRecyclerViewHolder noticeRecyclerViewHolder=new NoticeRecyclerViewHolder(view);
      //AgreementRecyclerViewHolder agreementRecyclerViewHolder=new AgreementRecyclerViewHolder(view);


        return noticeRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(NoticeRecyclerViewHolder holder,final int position) {

        holder.descripcion.setText(itemList3.get(position).getDescripcion());
      //holder.descripcion.setText(itemList5.get(position).getDescripcion());
        holder.titulo.setText(itemList3.get(position).getTitulo());
        Picasso.with(holder.imagen.getContext()).load(itemList3.get(position).getImagen()).into(holder.imagen);

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
        return itemList3.size();
    }
}



