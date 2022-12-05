package com.example.creditsummary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import com.example.creditsummary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        res(new trans_frag());
        activityMainBinding.BNB.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.trans:
                    res(new trans_frag());
                    break;
                case R.id.his:
                    res(new history_frag());
                    break;
                default:
                    break;

            }
            return true;
        });
        //Toast.makeText(MainActivity.this, "runned", Toast.LENGTH_SHORT).show();

    }
    public  void res(Fragment fragment){
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame , fragment);
        fragmentTransaction.commit();
    }
}