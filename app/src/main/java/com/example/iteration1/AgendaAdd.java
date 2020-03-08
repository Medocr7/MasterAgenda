package com.example.iteration1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class AgendaAdd extends Activity {

    @Override
    protected void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.agenda_adding);
        DisplayMetrics AgendaAddingDM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(AgendaAddingDM);
    }
}


