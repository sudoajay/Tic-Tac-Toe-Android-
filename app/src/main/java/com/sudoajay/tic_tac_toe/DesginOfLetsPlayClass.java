package com.sudoajay.tic_tac_toe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
public class DesginOfLetsPlayClass extends View {
    private Paint paint = new Paint();
    private boolean game_End= false;
    private RectF r ;
    private int which_Cross,cornerRadius = 50;
    public DesginOfLetsPlayClass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void onDraw(Canvas c) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);

        Log.i("Get WIth", getWidth()+"");
        Log.i("Get Height" , getHeight()+"");






        if ((getWidth() >= 0 && getWidth() <= 480) && (getHeight() >= 0 && getHeight() <= 820)) {
            c.drawLine(0, 200, getWidth(), 200, paint);// x-ray
            c.drawLine(0, 350, getWidth(), 350, paint);// x-ray
            c.drawLine(140, 60, 140, getHeight() - 270, paint);//y -ray
            c.drawLine(300, 60, 300, getHeight() - 270, paint);//y-ray

            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(72, 70, 87, 490);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(220, 70, 235, 490);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(370, 70, 385, 490);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 4:
                        r = new RectF(30, 120, 430, 135);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 5:
                        r = new RectF(30, 260, 430, 275);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(30, 415, 430, 430);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 7:
                        paint.setStrokeWidth(15);
                        c.drawLine(40, 100, 420, 450, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(15);
                        c.drawLine(420, 100, 40, 450, paint);
                        break;
                }
            }
        } else if ((getWidth() >= 480 && getWidth() <= 600) && (getHeight() >= 820 && getHeight() <= 1050)) {

            c.drawLine(0, 310, getWidth(), 310, paint);// x-ray
            c.drawLine(0, 410, getWidth(), 410, paint);// x-ray
            c.drawLine(160, 180, 160, getHeight() - 270, paint);//y -ray
            c.drawLine(320, 180, 320, getHeight() - 270, paint);//y-ray

            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(92, 210, 107, 520);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(250, 210, 265, 520);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(410, 210, 425, 520);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 4:
                        r = new RectF(50, 260, 450, 275);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(50, 360, 450, 375);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 6:
                        r = new RectF(50, 460, 450, 475);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 7:
                        paint.setStrokeWidth(15);
                        c.drawLine(80, 250, 440, 480, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(15);
                        c.drawLine(440, 250, 80, 480, paint);
                        break;
                }
            }
        } else if ((getWidth() >= 600 && getWidth() <= 740) && (getHeight() >= 1050 && getHeight() <= 1200)) {
            c.drawLine(0, 330, getWidth(), 330, paint);// x-ray
            c.drawLine(0, 530, getWidth(), 530, paint);// x-ray
            c.drawLine(225, 170, 225, getHeight() - 380, paint);//y -ray
            c.drawLine(475, 170, 475, getHeight() - 380, paint);//y-ray


            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(108, 150, 123, 720);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 2:
                        r = new RectF(340, 150, 355, 720);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(575, 150, 590, 720);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 4:
                        r = new RectF(60, 230, 650, 245);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 5:

                        r = new RectF(60, 430, 650, 445);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(60, 620, 650, 635);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 7:
                        paint.setStrokeWidth(15);
                        c.drawLine(40, 180, 640, 700, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(15);
                        c.drawLine(640, 180, 60, 700, paint);
                        break;
                }
            }
        } else if ((getWidth() >= 740 && getWidth() <= 800) && (getHeight() >= 1100 && getHeight() <= 1200)) {
            c.drawLine(0, 330, getWidth(), 330, paint);// x-ray
            c.drawLine(0, 530, getWidth(), 530, paint);// x-ray
            c.drawLine(225, 170, 225, getHeight() - 380, paint);//y -ray
            c.drawLine(475, 170, 475, getHeight() - 380, paint);//y-ray


            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(123, 150, 137, 720);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(370, 150, 385, 720);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(620, 150, 635, 720);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 4:
                        r = new RectF(60, 230, 700, 245);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(60, 430, 700, 445);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(60, 620, 700, 635);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 7:
                        paint.setStrokeWidth(15);
                        c.drawLine(80, 190, 680, 680, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(15);
                        c.drawLine(700, 190, 60, 680, paint);
                        break;
                }
            }
        } else if ((getWidth() >= 700 && getWidth() <= 760) && (getHeight() >= 1200 && getHeight() <= 1300)) {
            c.drawLine(0, 400, getWidth(), 400, paint);// x-ray
            c.drawLine(0, 600, getWidth(), 600, paint);// x-ray
            c.drawLine(225, 170, 225, getHeight() - 380, paint);//y -ray
            c.drawLine(475, 170, 475, getHeight() - 380, paint);//y-ray


            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(112, 220, 127, 790);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(350, 220, 365, 790);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(570, 220, 585, 790);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 4:
                        r = new RectF(60, 300, 650, 315);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(60, 500, 650, 515);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(60, 690, 650, 705);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 7:
                        paint.setStrokeWidth(15);
                        c.drawLine(50, 240, 650, 770, paint);

                        break;
                    case 8:
                        paint.setStrokeWidth(15);
                        c.drawLine(650, 240, 50, 760, paint);
                        break;
                }
            }
        } else if ((getWidth() >= 1000 && getWidth() <= 1120) && (getHeight() >= 1650 && getHeight() <= 1720)) {
            c.drawLine(0, 480, getWidth(), 480, paint);// x-ray
            c.drawLine(0, 810, getWidth(), 810, paint);// x-ray
            c.drawLine(320, 180, 320, getHeight() - 600, paint);//y -ray
            c.drawLine(680, 180, 680, getHeight() - 600, paint);//y-ray

            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(160, 210, 180, 1100);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(510, 210, 530, 1100);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(860, 210, 880, 1100);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 4:
                        r = new RectF(60, 350, 990, 370);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(60, 630, 990, 650);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(60, 930, 990, 950);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 7:
                        paint.setStrokeWidth(20);
                        c.drawLine(80, 270, 1000, 1050, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(20);
                        c.drawLine(1000, 250, 80, 1050, paint);
                        break;
                }
            }
        } else if ((getWidth() >= 1000 && getWidth() <= 1120) && (getHeight() >= 1720 && getHeight() <= 1760)) {
            c.drawLine(0, 560, getWidth(), 560, paint);// x-ray
            c.drawLine(0, 830, getWidth(), 830, paint);// x-ray
            c.drawLine(340, 240, 340, getHeight() - 600, paint);//y -ray
            c.drawLine(700, 240, 700, getHeight() - 600, paint);//y-ray


            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(190, 330, 210, 1080);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 2:
                        r = new RectF(530, 330, 550, 1080);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(890, 330, 910, 1080);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 4:
                        r = new RectF(80, 425, 990, 445);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(80, 675, 990, 695);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(80, 940, 990, 960);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 7:
                        paint.setStrokeWidth(20);
                        c.drawLine(130, 380, 980, 1030, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(20);
                        c.drawLine(980, 380, 130, 1030, paint);
                        break;
                }
            }
        }
        else if ((getWidth() >= 1200 && getWidth() <= 1600) && (getHeight() >= 2200 && getHeight() <= 4000)) {
            c.drawLine(0, 750, getWidth(), 750, paint);// x-ray
            c.drawLine(0, 1090, getWidth(), 1090, paint);// x-ray
            c.drawLine(450, 330, 450, getHeight() - 750, paint);//y -ray
            c.drawLine(940, 330, 940, getHeight() - 750, paint);//y-ray

            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(250, 410, 270, 1440);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(710, 410, 730, 1440);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(1170, 410, 1190, 1440);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 4:
                        r = new RectF(140, 590, 1320, 610);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(140, 930, 1320, 950);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(140, 1250, 1320, 1270);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);

                        break;
                    case 7:
                        paint.setStrokeWidth(20);
                        c.drawLine(190, 500, 1290, 1340, paint);
                        break;
                    case 8:
                        paint.setStrokeWidth(20);
                        c.drawLine(1290, 500, 190, 1340, paint);
                        break;
                }
            }
    }else {
            c.drawLine(0, 400, getWidth(), 400, paint);// x-ray
            c.drawLine(0, 600, getWidth(), 600, paint);// x-ray
            c.drawLine(225, 170, 225, getHeight() - 380, paint);//y -ray
            c.drawLine(475, 170, 475, getHeight() - 380, paint);//y-ray


            if (game_End) {
                paint.setColor(Color.parseColor("#efa71f"));
                switch (which_Cross) {
                    case 1:
                        r = new RectF(112, 220, 127, 790);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 2:
                        r = new RectF(350, 220, 365, 790);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 3:
                        r = new RectF(570, 220, 585, 790);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 4:
                        r = new RectF(60, 300, 650, 315);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 5:
                        r = new RectF(60, 500, 650, 515);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 6:
                        r = new RectF(60, 690, 650, 705);
                        paint.setStyle(Paint.Style.FILL);
                        c.drawRoundRect(r, cornerRadius, cornerRadius, paint);
                        break;
                    case 7:
                        paint.setStrokeWidth(15);
                        c.drawLine(50, 240, 650, 770, paint);

                        break;
                    case 8:
                        paint.setStrokeWidth(15);
                        c.drawLine(650, 240, 50, 760, paint);
                        break;
                }
            }
        }
    }
    public void get_Game_Ends(int which_Cross){
        this.which_Cross = which_Cross;
       game_End = true;
        invalidate();
    }
    public void setGame_End(boolean game_End) {
        this.game_End = game_End;
    }
}
