package com.example.zadankozczerwca;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button polub, zapisz, usun;
    private TextView polubienia;
    private int iloscPolubien = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        polub = findViewById(R.id.button);
        zapisz = findViewById(R.id.button3);
        polubienia = findViewById(R.id.textView2);
        usun = findViewById(R.id.button2);

        if(savedInstanceState != null){
            iloscPolubien =  savedInstanceState.getInt("wartoscZapisanychPolubien");
            polubienia.setText(iloscPolubien + " polubień");

        }

        usun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(iloscPolubien > 0){
                            iloscPolubien--;
                            polubienia.setText(iloscPolubien + " polubień");
                        }

                    }
                }
        );

        polub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iloscPolubien++;
                        polubienia.setText(iloscPolubien + " polubień");
                    }
                }
        );

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("wartoscZapisanychPolubien", iloscPolubien);
    }


}