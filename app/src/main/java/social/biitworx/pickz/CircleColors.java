package social.biitworx.pickz;

public class CircleColors{
    public static int BACK_CIRCLE_INNER;
    public static int BACK_CIRCLE_USED;
    public static int BACK_CIRCLE_UNUSED;
    public static int BACK_CIRCLE_OUTER;
    public static int BACK_CIRCLE_MINUS;


    public CircleColors inner(int inner){
        BACK_CIRCLE_INNER = inner;
        return this;
    }
    public CircleColors used(int used){
        BACK_CIRCLE_USED = used;
        return this;
    }
    public CircleColors unused(int unused){
        BACK_CIRCLE_UNUSED = unused;
        return this;
    }
    public CircleColors outer(int outer){
        BACK_CIRCLE_OUTER = outer;
        return this;
    }
    public CircleColors minus(int minus){
        BACK_CIRCLE_MINUS = minus;
        return this;
    }
}
