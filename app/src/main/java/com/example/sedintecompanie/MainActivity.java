package com.example.sedintecompanie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sedintecompanie.model.Sedinta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //https://jsonkeeper.com/b/IQL0

    private Spinner spnCompanie;
    private CheckBox checkBoxProiector;
    private CheckBox checkBoxTabla;
    private DatePicker datePicker;
    private EditText editTextNrScaune;
    private Button btnSave;

    private String[] companii=new String[]{"Alfa","Beta","Gamma"};

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCompanie=findViewById(R.id.spn_companie);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                companii);
        spnCompanie.setAdapter(adapter);

        checkBoxProiector=findViewById(R.id.checkbox_areProiector);
        checkBoxTabla=findViewById(R.id.checkbox_areTabla);

        datePicker=findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date=year+"-"+monthOfYear+"-"+dayOfMonth;
            }
        });

        editTextNrScaune=findViewById(R.id.et_nrScaune);

        btnSave=findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sedinta sedinta=new Sedinta();
                String nrScaune=editTextNrScaune.getText().toString();
                int nr=0;
                if (!nrScaune.isEmpty()) {
                   nr=Integer.parseInt(nrScaune);
                }
                sedinta.setNrScaune(nr);
                sedinta.setAreProiector(checkBoxProiector.isChecked());
                sedinta.setAreTabla(checkBoxTabla.isChecked());
                sedinta.setCompanie(spnCompanie.getSelectedItem().toString());
                try {
                    if (date==null){
                        int year=datePicker.getYear();
                        int monthOfYear=datePicker.getMonth();
                        int dayOfMonth=datePicker.getDayOfMonth();
                        date=year+"-"+monthOfYear+"-"+dayOfMonth;
                    }
                    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
                    sedinta.setDate(date1);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(getApplicationContext(),ListSedinteActivity.class);
                intent.putExtra("sedinta",sedinta);
                startActivity(intent);
            }
        });
    }
}