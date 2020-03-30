package com.example.iteration1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class AgendaViewing extends Activity {

    TextView read_txt;

    @Override
protected void onCreate (Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.agenda_viewing);
        DisplayMetrics AgendaViewingDM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(AgendaViewingDM);

        read_txt = findViewById(R.id.ViewAgenda);
        String txt;

        try {
            InputStream readAgenda = getAssets().open("TEST.txt");
            int size = readAgenda.available();
            byte[] buffer = new byte[size];
            readAgenda.read(buffer);
            readAgenda.close();
            txt = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            txt = "error";
        }
        read_txt.setText(txt);

    }

}
