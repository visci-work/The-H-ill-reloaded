package com.example.thehillreloaded.gameplay.falling_objects;

import static com.example.thehillreloaded.menu.MenuActivity.densityRatio;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioX;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.thehillreloaded.R;

public class SunnyPow extends PowerUp {

    private Bitmap sunnyPow;

    public SunnyPow(int x, int y, Resources res) {
        super(x,y);
        setJunkType("sunny_pow");

        sunnyPow = BitmapFactory.decodeResource(res, R.drawable.sun_powerup);

        super.setWidth((int) (sunnyPow.getWidth() * screenRatioX * densityRatio/ 7));
        super.setHeight((int) (sunnyPow.getHeight() * screenRatioY * densityRatio/ 7));

        sunnyPow = Bitmap.createScaledBitmap(sunnyPow, getWidth(), getHeight(), true);
    }

    @Override
    public Bitmap getFallingObject() {
        return sunnyPow;
    }
}
