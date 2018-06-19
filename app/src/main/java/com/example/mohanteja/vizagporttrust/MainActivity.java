package com.example.mohanteja.vizagporttrust;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnElectronics= (Button) findViewById(R.id.btnElectronics);
        Button btnCranes= (Button) findViewById(R.id.btnCranes);
        Button btnFloatingCraftSection= (Button) findViewById(R.id.btnFloatingCraftsSection);
        Button btnBGLocos= (Button) findViewById(R.id.btnBGLocos);
        Button btnPowerDistribution= (Button) findViewById(R.id.btnPowerDistribution);
        Button btnPumpHouse= (Button) findViewById(R.id.btnPumpHouse);
        Button btnLighting= (Button) findViewById(R.id.btnlighting);

        btnElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getApplicationContext(),ElectronicsActivity.class);
                startActivity(intent);
            }
        });

        btnBGLocos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCranes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         btnFloatingCraftSection.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         btnLighting.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         btnPowerDistribution.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         btnPumpHouse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

    }





}
