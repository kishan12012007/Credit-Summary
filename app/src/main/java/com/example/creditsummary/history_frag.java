package com.example.creditsummary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link history_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class history_frag extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView2;
    ArrayList<model> arrayList;
    ArrayList<model2> final_statements;
    View myview2;
    DBhandler dBhandler2;
    adapter2  adapter_2;
    String[] languages = { "All" , "Petrol Spend" , "Groceries Spend" ,"eWallet Transaction" , "All Other Eligible Spend"};
    Spinner dropdown2;
    public history_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment history_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static history_frag newInstance(String param1, String param2) {
        history_frag fragment = new history_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(myview2 == null) {
            myview2 = inflater.inflate(R.layout.fragment_history_frag, container, false);
        }

        fetch_data("All");
        dropdown2 = myview2.findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, languages);
        dropdown2.setAdapter(adapter);

        //myview2.findViewById(R.id.spinner2).setOnClickListener(this);
        myview2.findViewById(R.id.fetch).setOnClickListener(this);


        return myview2;
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(getContext(), "sfsfsdf", Toast.LENGTH_SHORT).show();
          String option =  dropdown2.getSelectedItem().toString();
       // Toast.makeText(getContext(), option, Toast.LENGTH_SHORT).show();
          fetch_data(option);
    }
    public  void fetch_data(String option){

        if(option == "All"){
            recyclerView2 = myview2.findViewById(R.id.recycler2);
           final_statements = new ArrayList<>();
        dBhandler2 = new DBhandler(getContext());
        arrayList = new ArrayList<>();
        arrayList = dBhandler2.readCourses();
        TextView total_cash_back = myview2.findViewById(R.id.total_cash);
        Float kishan = 0.0f;
        for(model i:arrayList){
            String str = i.getType();
            String val = i.getCash();
            int value = Integer.parseInt(val);
            float ans = 0.0f;
            if(value >= 2000){
                ans = value*((float)8/100);
            }
            else{
                ans = value*((float)1/100);
            }
            kishan = kishan + ans;
            String cash_back_earned = Float.toString(ans);
            final_statements.add(new model2(i.getName() ,i.getDate() , i.getCash() ,i.getType() , cash_back_earned));
        }
        String l = Float.toString(kishan);
        total_cash_back.setText("Total Cash Back earned from " + option + "= " + l);
        //final_statements.add(new model2("fist" ,"ds", "sfs" ,"df" ,"sfd"));
        adapter_2 = new adapter2(final_statements , getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(adapter_2);
        }
        else{
            //Toast.makeText(getContext(), option, Toast.LENGTH_SHORT).show();
            ArrayList<model2> filter_data = new ArrayList<>();
            int count = 0;
            Float last = 0.0f;
            for(model2 it:final_statements){
                String a = it.getCategory_1();
                String b = option;
                if(option.length() ==a.length()){
                    Boolean flag = true;
                    for(int i=0;i<option.length();i++){
                        if(option.charAt(i) != a.charAt(i)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        filter_data.add(it);
                        last += Float.parseFloat(it.getCash_back());
                    }
                }
            }
            String k = Float.toString(last);
            TextView textView = myview2.findViewById(R.id.total_cash);
            textView.setText( "Total CashBack earned from " + option + " = " +  k);
            //Toast.makeText(getContext(), Integer.toString(count), Toast.LENGTH_SHORT).show();
            adapter_2.changed(filter_data);
        }


//        recyclerView2 = myview2.findViewById(R.id.recycler2);
//        final_statements = new ArrayList<>();
//        dBhandler2 = new DBhandler(getContext());
//        arrayList = new ArrayList<>();
//        arrayList = dBhandler2.readCourses();
//        TextView total_cash_back = myview2.findViewById(R.id.total_cash);
//
//        for(model i:arrayList){
//            String str = i.getType();
//            String val = i.getCash();
//            int value = Integer.parseInt(val);
//            float ans = 0.0f;
//            if(value >= 2000){
//                ans = value*((float)8/100);
//            }
//            else{
//                ans = value*((float)1/100);
//            }
//            String cash_back_earned = Float.toString(ans);
//            final_statements.add(new model2(i.getName() ,i.getDate() , i.getCash() ,i.getType() , cash_back_earned));
//        }
//        //final_statements.add(new model2("fist" ,"ds", "sfs" ,"df" ,"sfd"));
//        adapter_2 = new adapter2(final_statements , getContext());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView2.setLayoutManager(linearLayoutManager);
//        recyclerView2.setAdapter(adapter_2);
    }
}