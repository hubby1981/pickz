package social.biitworx.pickz;

/**
 * Created by marcel.weissgerber on 09.11.2015.
 */
public class CircleSubHelper {

    public static CircleCollection getCollection (String id){
        CircleCollection c = new CircleCollection();
        c.readMenuCircle(FileHelper.getObject(id.concat(".txt")));
        return  c;
    }
}
