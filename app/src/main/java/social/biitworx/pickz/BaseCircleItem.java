package social.biitworx.pickz;

import android.graphics.Bitmap;

/**
 * Created by marcel.weissgerber on 06.11.2015.
 */
public abstract class BaseCircleItem {

    public int backcolor =android.graphics.Color.argb(255,100,100,100);
    public int degree = 0;
    public Bitmap icon=null;
    public boolean expose=false;
    private int mover=20;
    public String name="";
    Runnable runAction=null;
public boolean couldExpose = true;
    public BaseCircleItem(Bitmap icon){
        this.icon = icon;
    }

    public BaseCircleItem action(Runnable action){
        this.runAction = action;
        return this;
    }
    public BaseCircleItem exposing(boolean expose){
        this.couldExpose = expose;
        return this;
    }


    public BaseCircleItem exposed(boolean expose){
        this.expose = expose;
        return this;
    }

    public void move(){
        degree +=mover;
        if(degree >= 360)degree=0;
    }

    public void moveL(){
        if(degree <= 0)degree=360;
        degree -=mover;
    }


    public BaseCircleItem text(String text){
        this.name = text;
        return this;
    }

    public boolean mustMoveL(){
        return degree<180 && degree>0;
    }

    public boolean isMoved(){
        return degree==0;
    }

    public BaseCircleItem color (int color){
        this.backcolor=color;
        return this;
    }


    public <T> T get(){
        return (T)this;
    }



}
