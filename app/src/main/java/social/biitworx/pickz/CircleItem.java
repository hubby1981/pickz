package social.biitworx.pickz;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by marcel.weissgerber on 05.11.2015.
 */
public class CircleItem extends BaseCircleItem {



    private int counter=0;

    public String name="";
    public String unit="";
    private int maxTime=5;
    private int maxCount=24;

    public CircleItem(Bitmap icon) {
        super(icon);
    }

    public int countTime(){
        return unit.equals("hours")?counter*60:maxTime>0?maxTime*counter:0;
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

    public int getCount(){
        return counter;
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
