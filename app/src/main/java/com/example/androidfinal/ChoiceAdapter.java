package com.example.androidfinal;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.MyViewHolder> {


    public ArrayList<View> itemViewList = new ArrayList<>();
    public int choices[];
    private OnItemClickListener mListener;

    public ChoiceAdapter(int[] choices) {

        this.choices = choices;

    }

    public void setColor(int position){
        for (int i = 0; i < choices.length; i++) {
            if(i == position){

                itemViewList.get(i).setBackgroundColor(Color.parseColor("#567845"));
            }else{
                itemViewList.get(i).setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView choiceText;
        CardView cardView;
//        private LinearLayout linearLayout;
//        private CardView cardView;


        public MyViewHolder(final View itemView, final ChoiceAdapter.OnItemClickListener listener) {
            super(itemView);
            choiceText = itemView.findViewById(R.id.choiceText);

//            linearLayout = itemView.findViewById(R.id.linearLayout);
//            cardView = itemView.findViewById(R.id.cardView);
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
    public ChoiceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_question_layout, parent, false);
        ChoiceAdapter.MyViewHolder holder = new ChoiceAdapter.MyViewHolder(v, mListener);
        itemViewList.add(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ChoiceAdapter.MyViewHolder holder, int position) {
        holder.choiceText.setText(choices[position]);
    }

    @Override
    public int getItemCount() {
        return choices.length;
    }
}