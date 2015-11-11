package social.biitworx.pickz;

import java.util.HashMap;

/**
 * Created by marcel.weissgerber on 09.11.2015.
 */
public class CircleActions {
    private static HashMap<String, Runnable> actions;

    static {
        actions = new HashMap<>();
        actions.put("7", new Runnable() {
            @Override
            public void run() {
                CircleView.State = 0;
                CircleView.collectionRight = new CircleCollection();
            }
        });
        actions.put("8", new Runnable() {
            @Override
            public void run() {
                CircleView.State = 1;
                CircleView.collectionRight = new CircleCollection();
            }
        });
        actions.put("9", new Runnable() {
            @Override
            public void run() {
                CircleView.State = 2;
                CircleView.collectionRight = new CircleCollection();
            }
        });
        actions.put("1", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("1");
            }
        });
        actions.put("2", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("2");
            }
        });
        actions.put("3", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("3");
            }
        });
        actions.put("4", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("4");
            }
        });
        actions.put("5", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("5");
            }
        });
        actions.put("51", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("51");
            }
        });
        actions.put("41", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("41");
            }
        });
        actions.put("416", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("4");
            }
        });
        actions.put("4154", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("41");
            }
        });
        actions.put("415", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("415");
            }
        });
        actions.put("513", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("5");
            }
        });
        actions.put("6", new Runnable() {
            @Override
            public void run() {

                CircleView.collectionRight = CircleSubHelper.getCollection("6");
            }
        });

    }

    public static Runnable getAction(String id) {
        return actions.get(id);
    }
}
