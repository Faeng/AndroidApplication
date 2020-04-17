package com.example.androidfinal;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public String title[] ;
    public String description[] ;
    public int image[];
    private OnItemClickListener mListener;

    public MyAdapter(int[] image,String[] title, String[] description) {

        this.image = image;
        this.title = title;
        this.description = description;

    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMain,textViewSub;
        ImageView imageView;

        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewMain = itemView.findViewById(R.id.mainTitle);
            textViewSub = itemView.findViewById(R.id.subTitle);
            imageView = itemView.findViewById(R.id.imageTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(v, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(image[position]);
        holder.textViewMain.setText(title[position]);
        holder.textViewSub.setText(description[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

}