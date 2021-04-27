package com.example.myapplication01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView2Adapter extends RecyclerView.Adapter<RecyclerView2Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }

        public void setData(int index) {
            Memo2 memo = arrayList.get(index);
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Memo2> arrayList;

    public RecyclerView2Adapter(Context context, ArrayList<Memo2> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.memo2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int index) {
        viewHolder.setData(index);
    }


}
