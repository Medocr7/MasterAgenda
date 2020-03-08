package com.example.iteration1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class AgendaAdd extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.agenda_adding);
        DisplayMetrics AgendaAddingDM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(AgendaAddingDM);

        Button set_Date = findViewById(R.id.date_Select);
        set_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String current_Date_Set = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView set_Date = findViewById(R.id.view_Date);
        set_Date.setText(current_Date_Set);
    }
}





