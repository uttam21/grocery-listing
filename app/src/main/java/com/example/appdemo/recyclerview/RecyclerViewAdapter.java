package com.example.appdemo.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<ItemDetails> itemDetailsList;
    private Context mContext;

    public RecyclerViewAdapter(List<ItemDetails> itemDetailsList, Context mContext) {
        this.itemDetailsList = itemDetailsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_item_layout,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.txt_item_title.setText(itemDetailsList.get(position).getTitle());
        holder.img_item_thumbnail.setImageResource(itemDetailsList.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ItemViewActivity.class);

                intent.putExtra("TITLE",itemDetailsList.get(position).getTitle());
                intent.putExtra("CATEGORY",itemDetailsList.get(position).getCategory());
                intent.putExtra("DESCRIPTION",itemDetailsList.get(position).getDescription());
                intent.putExtra("THUMBNAIL",itemDetailsList.get(position).getThumbnail());

                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return itemDetailsList.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder
    {
       private TextView txt_item_title;
       ImageView img_item_thumbnail;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_item_title = (TextView) itemView.findViewById(R.id.item_title_id);
            img_item_thumbnail = (ImageView)itemView.findViewById(R.id.item_img_id);
            cardView= (CardView)itemView.findViewById(R.id.cardview_id);


        }
    }

}
