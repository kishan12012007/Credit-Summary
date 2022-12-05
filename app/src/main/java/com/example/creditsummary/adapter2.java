package com.example.creditsummary;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter2  extends RecyclerView.Adapter<adapter2.viewHolder>  {

    ArrayList<model2> list;
    Context context;

    public void changed(ArrayList<model2> res){
        this.list = res;
        notifyDataSetChanged();
    }
    public  class viewHolder extends RecyclerView.ViewHolder {

        TextView a ,b ,c, d , e;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            a = itemView.findViewById(R.id.name3);
            b = itemView.findViewById(R.id.date3);
            c = itemView.findViewById(R.id.cash3);
            d = itemView.findViewById(R.id.category3);
            e = itemView.findViewById(R.id.total3);
        }
    }
    public adapter2(ArrayList<model2> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.structure2 , parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  viewHolder holder, int position) {
        model2 obj = list.get(position);
        holder.a.setText("Name : " + obj.getName_1());
        holder.b.setText( "Date : " + obj.getDate_1());
        holder.c.setText( "Cash spend : " + obj.getCash_1());
        holder.d.setText( "Category : " +  obj.getCategory_1());
        holder.e.setText( "Total Cash back Earned : " +  obj.getCash_back());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
