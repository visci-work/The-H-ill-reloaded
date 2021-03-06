package com.example.thehillreloaded.gameplay.imageclass;

import static com.example.thehillreloaded.menu.MenuActivity.densityRatio;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioX;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.thehillreloaded.R;

public class IncineratorInfo extends InfoImages {

    public IncineratorInfo(int x, int y, Resources res) {
        super(x,y);

        setImageBitmap(BitmapFactory.decodeResource(res, R.drawable.incinerator));
        setImageBitmap2(BitmapFactory.decodeResource(res, R.drawable.power_plant));

        super.setWidth((int)(getImageBitmap().getWidth() * screenRatioX * densityRatio/3.6));
        super.setHeight((int)(getImageBitmap().getHeight() * screenRatioY * densityRatio/3.6));
        setImageBitmap(Bitmap.createScaledBitmap(getImageBitmap(), getWidth(), getHeight(), true));

        super.setWidth((int)(getImageBitmap2().getWidth() * screenRatioX * densityRatio/11));
        super.setHeight((int)(getImageBitmap2().getHeight() * screenRatioY * densityRatio/11));
        setImageBitmap2(Bitmap.createScaledBitmap(getImageBitmap2(), getWidth(), getHeight(), true));
    }
}