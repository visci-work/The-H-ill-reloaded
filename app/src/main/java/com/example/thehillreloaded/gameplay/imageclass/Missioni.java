package com.example.thehillreloaded.gameplay.imageclass;

import static com.example.thehillreloaded.menu.MenuActivity.densityRatio;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioX;
import static com.example.thehillreloaded.menu.MenuActivity.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.thehillreloaded.R;

public class Missioni extends  RecImages{

    private String descrizione;
    private int totJunkRec = 0, totRecUpgr = 0, totSunnyAccum = 0, totUnitPointsUsed = 0;
    private int goalJunkRec = 50, goalRecUpgr = 5, goalSunnyAccum = 60, goalUnitPointsUsed = 30;
    private int missionType;

    public Missioni(int x, int y, Resources res){
        super(x, y);

        setImageBitmap(BitmapFactory.decodeResource(res, R.drawable.goal));
        super.setWidth((int)(getImageBitmap().getHeight() * screenRatioX * densityRatio/11));
        super.setHeight((int)(getImageBitmap().getWidth() * screenRatioY * densityRatio/11));
        setImageBitmap(Bitmap.createScaledBitmap(getImageBitmap(), getWidth(), getHeight(), true));

    }

    public Missioni(int x, int y, int type, String descr, Resources res){
        super(x, y);
        setMissionType(type);
        setDescrizione(descr);
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setMissionType(int type) {
        this.missionType = type;
    }

    public int getMissionType(){
        return missionType;
    }

    public int getTotJunkRec() {
        return totJunkRec;
    }

    public void setTotJunkRec(int totJunkRec) {
        this.totJunkRec += totJunkRec;
    }

    public int getTotRecUpgr() {
        return totRecUpgr;
    }

    public void setTotRecUpgr(int totRecUpgr) {
        this.totRecUpgr += totRecUpgr;
    }

    public int getTotSunnyAccum() {
        return totSunnyAccum;
    }

    public void setTotSunnyAccum(int totSunnyAccum) {
        this.totSunnyAccum += totSunnyAccum;
    }

    public int getTotUnitPointsUsed() {
        return totUnitPointsUsed;
    }

    public void setTotUnitPointsUsed(int totUnitPointsUsed) {
        this.totUnitPointsUsed += totUnitPointsUsed;
    }

    public int getGoalJunkRec() {
        return goalJunkRec;
    }

    public int getGoalRecUpgr() {
        return goalRecUpgr;
    }

    public int getGoalSunnyAccum() {
        return goalSunnyAccum;
    }

    public int getGoalUnitPointsUsed() {
        return goalUnitPointsUsed;
    }
}
