package com.example.thehillreloaded.gameplay.junk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.thehillreloaded.R;

import static com.example.thehillreloaded.gameplay.GameView.screenRatioX;
import static com.example.thehillreloaded.gameplay.GameView.screenRatioY;


public class Glass extends Junk {

    private static double tasso = 1;
    private Bitmap glass;

    public Glass(int x, int y, Resources res) {
        super(x, y);

        glass = BitmapFactory.decodeResource(res, R.drawable.glass);

        super.setWidth((int) (glass.getWidth() * screenRatioX/1.7));
        super.setHeight((int) (glass.getHeight() * screenRatioY/1.7));

        glass = Bitmap.createScaledBitmap(glass, getWidth(), getHeight(), true);
    }

    public static void rinnovaTasso() {
        if (tasso > 0.15834) {
            tasso -= 0.0002;
        }
    }

    public static double getTasso() {
        return tasso;
    }

    @Override
    public Bitmap getJunk() {
        return glass;
    }
}