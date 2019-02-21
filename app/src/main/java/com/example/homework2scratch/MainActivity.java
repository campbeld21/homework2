package com.example.homework2scratch;

//@Author: David Campbell

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class MainActivity -->
 *
 * This class creates a reference for every necessary element to be used.
 * It also displays the content view of the layout activity main.
 *
 * @author David Campbell
 * @version Spring 2019
 *
 */



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //All of the necessary elements are found here and are used to be
        //referenced from other classes.
        DrawingInterface surfaceView = findViewById(R.id.largeSurfaceView);
        TextView textView = findViewById(R.id.current_display_element);
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
        TextView redColValue = findViewById(R.id.redColorValue);
        TextView blueColValue = findViewById(R.id.blueColorValue);
        TextView greenColValue = findViewById(R.id.greenColorValue);


        Controller drawingController = new Controller(textView, redSeekBar, blueSeekBar,
                                                      greenSeekBar, surfaceView,
                                                      redColValue, blueColValue, greenColValue);


    }



}
