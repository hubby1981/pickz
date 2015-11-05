package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by marcel.weissgerber on 05.11.2015.
 */
public class CircleItem {

    public int backcolor =android.graphics.Color.argb(255,100,100,100);
    public int degree = 0;
    private int counter=0;
    public Bitmap icon=null;
    public boolean expose=false;
    public String name="";
    public String unit="";
    private int maxTime=5;
    private int maxCount=24;

    public CircleItem(Bitmap icon){
        this(icon,0);
    }
    public CircleItem(Bitmap icon,int counter){
        this.icon =icon;
    }


    public void move(){
        degree +=30;
        if(degree == 360)degree=0;
    }

    public void moveL(){
        if(degree == 0)degree=360;
        degree -=30;
    }

    public int countTime(){
        return unit.equals("hrs")?counter*60:maxTime>0?maxTime*counter:0;
    }

    public boolean mustMoveL(){
        return degree<180 && degree>0;
    }

    public boolean isMoved(){
        return degree==0;
    }

    public CircleItem color (int color){
        this.backcolor=color;
        return this;
    }

    public CircleItem text(String text){
        this.name = text;
        return this;
    }

    public CircleItem units(String unit){
        this.unit = unit;
        return this;
    }

    public CircleItem count(int count){
        this.counter = count;
        return this;
    }

    public CircleItem max(int max){
        this.maxTime = max;
        return this;
    }

    public CircleItem limit(int max){
        this.maxCount = max;
        return this;
    }

    public String getCounter(){
        return String.valueOf(counter).concat(" ").concat(unit);
    }

    public CircleItem plus(){
        if(counter<maxCount)
            this.counter+=1;
        return this;
    }
    public CircleItem minus(){
        if(counter>0)
            this.counter-=1;
        return this;
    }
}
