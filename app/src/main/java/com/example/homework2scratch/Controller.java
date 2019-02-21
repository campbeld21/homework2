package com.example.homework2scratch;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * <!-- class Controller -->
 *
 * This class controls the ontouch events as well
 * as the seekbar controls to determine whether or
 * not to change the color or color value.
 *
 * @author David Campbell
 * @version Spring 2019
 *
 */

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import static android.graphics.Color.rgb;



public class Controller implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    //All instance variables that will be used to access the seekbars and the textviews
    private DrawingInterface drawingInterface;
    private TextView currentDisplayItem = null;
    private SeekBar redSeekBar = null;
    private SeekBar blueSeekBar = null;
    private SeekBar greenSeekBar = null;
    private TextView redColValue = null;
    private TextView blueColValue = null;
    private TextView greenColValue = null;
    private CustomElement element = null;
    private int red, green, blue;






    //Takes in all the necesssary components to access the values from Drawing interface
    public Controller(TextView initTV, SeekBar initRedSB, SeekBar initBlueSB,
                      SeekBar initGreenSB, DrawingInterface initDrawingInterface,
                      TextView initRedColValue, TextView initBlueColValue, TextView initGreenColValue) {
        currentDisplayItem = initTV;
        redSeekBar = initRedSB;
        blueSeekBar = initBlueSB;
        greenSeekBar = initGreenSB;
        drawingInterface = initDrawingInterface;
        redColValue = initRedColValue;
        blueColValue = initBlueColValue;
        greenColValue = initGreenColValue;


        redSeekBar.setOnSeekBarChangeListener(this);
        blueSeekBar.setOnSeekBarChangeListener(this);
        greenSeekBar.setOnSeekBarChangeListener(this);
        drawingInterface.setOnTouchListener(this);




    }

    /*
    *   This method tells me when and where the screen is touched. If
    *   the screen is touched on a specific element, the current display
    *   element will change to the correct text.
    *
     */
    @Override
    public boolean onTouch(View v, MotionEvent event){
        int xTouch = (int)event.getX();
        int yTouch = (int)event.getY();



        if(drawingInterface.chimney.containsPoint(xTouch, yTouch)){
            element = drawingInterface.chimney;
            currentDisplayItem.setText("Chimney");
        }
        else if(drawingInterface.windowLeft.containsPoint(xTouch,yTouch)){
            currentDisplayItem.setText("Left Window");
            element = drawingInterface.windowLeft;
        }
        else if(drawingInterface.windowRight.containsPoint(xTouch,yTouch)){
            currentDisplayItem.setText("Right Window");
            element = drawingInterface.windowRight;
        }
        else if(drawingInterface.doorFrame.containsPoint(xTouch,yTouch)){
            currentDisplayItem.setText("Door");
            element = drawingInterface.doorFrame;
        }
        else if(drawingInterface.grass.containsPoint(xTouch,yTouch)){
            currentDisplayItem.setText("Grass");
            element = drawingInterface.grass;
        }
        else if(drawingInterface.houseFrame.containsPoint(xTouch,yTouch)){
            currentDisplayItem.setText("House");
            element = drawingInterface.houseFrame;
        }
        else if(drawingInterface.sunCircle.containsPoint(xTouch,yTouch)){
            currentDisplayItem.setText("Sun");
            element = drawingInterface.sunCircle;
        }
        else{
            currentDisplayItem.setText("Sky");
            element = drawingInterface.skyRect;
        }


        red = red(element.getColor());
        redSeekBar.setProgress(red);

        green = green(element.getColor());
        greenSeekBar.setProgress(green);

        blue = blue(element.getColor());
        blueSeekBar.setProgress(blue);


        return true;

    }

    /*
    *   This method tells me when and where the seekbars were moved.
    *   It sets the min and max from 0 to 255 and allows the seekbars to
    *   change the individual values of the RGB of each color.
    *
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        seekBar.setMax(255);
        seekBar.setMin(0);
        if(seekBar == redSeekBar){
            red = progress;
            redColValue.setText((int)progress + "");
        }
        if(seekBar == blueSeekBar){
            blue = progress;
            blueColValue.setText((int)progress +"");

        }
        if(seekBar == greenSeekBar){
            green = progress;
            greenColValue.setText((int)progress + "");

        }
        if(fromUser == true){
            element.setColor(rgb(red,green, blue));
            drawingInterface.invalidate();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /* ignore */    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /* ignore */    }


}