package com.example.creditsummary;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class my_adapter  extends RecyclerView.Adapter<my_adapter.viewHolder>  {

    ArrayList<model> list;
    Context context;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;
    String first, second, third , fourth;
    public  class viewHolder extends RecyclerView.ViewHolder {

        TextView a ,b ,c, d;
       // Button edit ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            a = itemView.findViewById(R.id.name3);
            b = itemView.findViewById(R.id.date3);
            c = itemView.findViewById(R.id.cash4);
            d = itemView.findViewById(R.id.category3);
          //  edit =itemView.findViewById(R.id.button);
        }
    }
    public my_adapter(ArrayList<model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.structure , parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  viewHolder holder, int position) {
        model obj = list.get(position);
        holder.a.setText( obj.getName());
        holder.b.setText(  obj.getDate());
        holder.c.setText(  obj.getCash());
        holder.d.setText(   obj.getType());

        
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
