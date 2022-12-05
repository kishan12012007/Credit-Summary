package com.example.creditsummary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Enter_details extends AppCompatActivity {

    final Calendar myCalendar= Calendar.getInstance();
    String[] languages = { "Petrol Spend" , "Groceries Spend" ,"eWallet Transaction" , "All Other Eligible Spend"};
    DBhandler dBhandler;
    Spinner dropdown;
    EditText date_picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        //Toast.makeText(Enter_details.this, "sdfdfsf", Toast.LENGTH_SHORT).show();

        dropdown = findViewById(R.id.category2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languages);
        dropdown.setAdapter(adapter);
        //Toast.makeText(Enter_details.this, "sdfdfsf", Toast.LENGTH_SHORT).show();
        findViewById(R.id.sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView first = findViewById(R.id.name2);
                String first_1 = first.getText().toString();
                String second = ((TextView)findViewById(R.id.cash2)).getText().toString();
                if(second.length() > 9){
                        Toast.makeText(Enter_details.this, "sorry , you can spend at most 100000000 amount", Toast.LENGTH_SHORT).show();
                        return ;
                }
                for(int i=0;i<second.length();i++){

                    if(second.charAt(i) >= '0' && second.charAt(i) <= '9'){
                        continue;
                    }
                    else {
                        Toast.makeText(Enter_details.this, "please enter a valid cash amount", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }
               //Toast.makeText(Enter_details.this, "sdfdsfd", Toast.LENGTH_SHORT).show();
                String third = dropdown.getSelectedItem().toString();
                String fourth = date_picker.getText().toString();
                if(first_1.isEmpty() || second.isEmpty() || third.isEmpty()){
                    Toast.makeText(Enter_details.this, "Please fill all sections", Toast.LENGTH_SHORT).show();
                    return ;
                }

                dBhandler = new DBhandler(Enter_details.this);
                dBhandler.addNewCourse(first_1 ,fourth ,second , third);
                first.setText("");
                TextView cash3 = findViewById(R.id.cash2);
                cash3.setText("");
                Toast.makeText(Enter_details.this, "Successfully submitted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enter_details.this , MainActivity.class);
                startActivity(intent);
            }
        });
        date_picker =(EditText) findViewById(R.id.date2);
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Enter_details.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        date_picker.setText(dateFormat.format(myCalendar.getTime()));
    }
}