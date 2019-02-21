package com.example.homework2scratch;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * <!-- class DrawingInterface -->
 *
 * This class creates and draws all objects onto the
 * SurfaceView
 *
 * @author David Campbell
 * @version Spring 2019
 *
 */


public class DrawingInterface extends SurfaceView  {

    public static int rectLeft = 600;
    public static int rectTop = 500;
    public static int rectRight = 850;
    public static int rectBottom = 775;

    public static int doorLeft = 700;
    public static int doorTop = 650;
    public static int doorRight = 750;
    public static int doorBottom = 775;

    public static int leftLWindow = 625;
    public static int topLWindow = 550;
    public static int rightLWindow = 675;
    public static int bottomLWindow = 625;

    public static int leftRWindow = 775;
    public static int topRWindow = 550;
    public static int rightRWindow = 825;
    public static int bottomRWindow = 625;

    public static int grassLeft = 0;
    public static int grassRight = 2200;
    public static int grassBottom = 1400;

    public static int chimneyLeft = 775;
    public static int chimneyTop  = 425;
    public static int chimneyRight = 825;
    public static int chimneyBottom = 500;

    public static int sunLeft = 0;
    public static int sunTop = 0;
    public static int sunRight = 200;
    public static int sunBottom = 200;

    public static int skyLeft = 0;
    public static int skyTop = 0;
    public static int skyRight = 2000;
    public static int skyBottom = rectBottom;

    String chimneyName = "Chimney";
    String windowLName = "Left Window";
    String windowRName = "Right Window";
    String doorFrameName = "Door Frame";
    String grassName = "Grass";
    String houseFrameName = "House Frame";
    String sunCircleName = "Sun";
    String skyRectName = "Sky";



        //Declaration and initialization of all CustomRects used for each modifiable element
        public CustomRect chimney = new CustomRect(chimneyName, 0xFFB22222, chimneyLeft, chimneyTop,
                                                    chimneyRight, chimneyBottom);

        public CustomRect windowLeft = new CustomRect(windowLName, 0xFF000000, leftLWindow, topLWindow,
                rightLWindow, bottomLWindow);

        public CustomRect windowRight = new CustomRect(windowRName, 0xFF000000, leftRWindow, topRWindow,
                rightRWindow, bottomRWindow);

        public CustomRect doorFrame = new CustomRect(doorFrameName, 0xFF5D572C,doorLeft, doorTop,
                doorRight, doorBottom);

        public CustomRect grass = new CustomRect(grassName, 0xFF006400, grassLeft, rectBottom,
                grassRight, grassBottom);

        public CustomRect houseFrame = new CustomRect(houseFrameName, 0xFF7FFF00, rectLeft, rectTop,
                rectRight,rectBottom);

        public CustomRect sunCircle = new CustomRect(sunCircleName, 0xFFFFFF00, sunLeft, sunTop,
            sunRight, sunBottom);

        public CustomRect skyRect = new CustomRect(skyRectName, 0xFF87CEFA, skyLeft, skyTop, skyRight, skyBottom);



    public DrawingInterface(Context context) {
        super(context);
        init();
    }

    public DrawingInterface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingInterface(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint("NewApi")
    public DrawingInterface(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    public void init(){
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawRGB(rSky, gSky, bSky);
        skyRect.drawMe(canvas);
        chimney.drawMe(canvas);
        houseFrame.drawMe(canvas);
        windowLeft.drawMe(canvas);
        windowRight.drawMe(canvas);
        doorFrame.drawMe(canvas);
        sunCircle.drawMe(canvas);
        grass.drawMe(canvas);

    }
}
