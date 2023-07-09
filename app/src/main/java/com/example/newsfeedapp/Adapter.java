package com.example.newsfeedapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private Context mContext;
    private List<ModelClass> mModel;

    public Adapter(Context mContext, List<ModelClass> mModel) {
        this.mContext = mContext;
        this.mModel = mModel;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_item,null,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, webView.class);
                intent.putExtra("url",mModel.get(position).getUrl());
                mContext.startActivity(intent);
            }
        });

        holder.time.setText("Published at :-"+mModel.get(position).getPublishedAt());
        holder.headLine.setText(mModel.get(position).getTitle());
        holder.content.setText(mModel.get(position).getDescription());
        holder.publisher.setText(mModel.get(position).getAuthor());
        Glide.with(mContext).load(mModel.get(position).getUrlToImage()).into(holder.newsImageView);


    }

    @Override
    public int getItemCount() {
        if (mModel != null) {
            return mModel.size();
        } else {
            return 0;
        }
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView headLine,content,publisher,time;
        public ImageView newsImageView;
        public CardView cardView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            headLine=itemView.findViewById(R.id.headLine);
            content=itemView.findViewById(R.id.content);
            publisher=itemView.findViewById(R.id.publisher);
            time=itemView.findViewById(R.id.time);
            newsImageView=itemView.findViewById(R.id.newsImageView);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
