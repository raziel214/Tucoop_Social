package com.taylor_johnson.realsocialnew.Model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.taylor_johnson.realsocialnew.R;

/**
 * Created by desarrolladorjf on 21/02/2017.
 */

public class Picture {
    private int picture;

    public Picture(int picture) {
        this.picture = picture;
    }


    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public class pictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;



        public pictureViewHolder(View itemView) {
            super(itemView);
            pictureCard     = (ImageView) itemView.findViewById(R.id.picture_Card);
                   }
    }
}
