package com.example.iteration1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.iteration1.SQLiteHelper.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        dbHandler = new DatabaseHandler(getApplicationContext());

        // This button will view all the Plans/Task that the user has added into the Agenda
        Button ViewTask = findViewById(R.id.Agenda);
        ViewTask.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //View all entered Agends
                dbHandler.getAllAgendaItems();
                if(DatabaseHandler.agendaList.size()>0){
                    for(int i=0;i < DatabaseHandler.agendaList.size(); i++){
                        Toast.makeText(MainActivity.this,"Agenda Name: " + DatabaseHandler.agendaList.get(i).getAgendaName() +
                                "Agenda Date: " + DatabaseHandler.agendaList.get(i).getAgendaDate(),Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,"No Agenda List Found",Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(MainActivity.this, AgendaViewing.class));


            }
        });
    /* This button will pop up a menu that will allow the user to add items into a date. Which will then be recorded and pulled up should the user ever
    exit the application.
    */
        Button AddPlans = findViewById(R.id.AgendaAdd);
        AddPlans.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AgendaAdd.class));
            }
        });
        // This button will pop up a view of the calender of the month ***TRACKS BASED ON REAL TIME***
        Button CalenderView = findViewById(R.id.CalenderView);
        CalenderView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewCalender.class));
            }
        });

        // Exits the App and pops with an error code of 0.
        Button ExitApp = findViewById(R.id.ExitApp);
        ExitApp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
