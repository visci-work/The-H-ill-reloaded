package com.example.thehillreloaded.gameplay.falling_objects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.thehillreloaded.R;

import static com.example.thehillreloaded.menu.DifficoltaActivity.tassoDifficolta;
import static com.example.thehillreloaded.menu.MenuActivity.densityRatio;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioX;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioY;


public class Plastic extends Junk {

    private static double tasso = 0;
    private static boolean tassoMassimoRaggiunto = false;
    private Bitmap plastic;

    public Plastic(int x, int y, Resources res) {
        super(x, y);
        setJunkType("plastic");

        plastic = BitmapFactory.decodeResource(res, R.drawable.plastic);

        super.setWidth((int) (plastic.getWidth() * screenRatioX * densityRatio/ 4.64));
        super.setHeight((int) (plastic.getHeight() * screenRatioY * densityRatio/ 4.64));

        plastic = Bitmap.createScaledBitmap(plastic, getWidth(), getHeight(), true);
    }

    public static void rinnovaTasso() {
        if (tassoMassimoRaggiunto) {
            if (tasso > 0.15834) {
                tasso -= 0.00008 * tassoDifficolta;
            }
        } else if (Aluminum.isTassoMassimoRaggiunto()) {
            tasso += 0.000025 * tassoDifficolta;
        }
    }

    public static void tassoMassimoRaggiunto() {
        if (tasso > 0.16) {
            tassoMassimoRaggiunto = true;
        }
    }

    public static boolean isTassoMassimoRaggiunto() {
        return tassoMassimoRaggiunto;
    }

    public static void setTassoMassimoRaggiunto(boolean new_tassoMassimoRaggiunto) {
        tassoMassimoRaggiunto = new_tassoMassimoRaggiunto;
    }

    public static double getTasso() {
        return tasso;
    }

    public static void setTasso(double new_tasso) {
        tasso = new_tasso;
    }

    public static void resetValues() {
        tasso = 0;
        tassoMassimoRaggiunto = false;
    }

    @Override
    public Bitmap getFallingObject() {
        return plastic;
    }
}

