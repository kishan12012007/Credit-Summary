package com.example.creditsummary;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link trans_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class trans_frag extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View myview;
    public RecyclerView recyclerView;
    public ArrayList<model> statements;
    public my_adapter adapter_1;
    public  DBhandler dBhandler;
    public trans_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment trans_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static trans_frag newInstance(String param1, String param2) {
        trans_frag fragment = new trans_frag();
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

        if(myview == null) {
            myview = inflater.inflate(R.layout.fragment_trans_frag, container, false);
        }
        myview.findViewById(R.id.FAB).setOnClickListener(this);
        recyclerView = myview.findViewById(R.id.recycler);
        statements = new ArrayList<>();
        dBhandler = new DBhandler(getContext());
        statements = dBhandler.readCourses();
        adapter_1 = new my_adapter(statements , getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter_1);
//        for(model i:statements){
//            dBhandler.deleteCourse(i.getName());
//        }
        return myview;
    }

    @Override
    public void onClick(View view) {
       // Toast.makeText(getContext(), "successfully completed", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext() , Enter_details.class);
        startActivity(intent);

    }

}