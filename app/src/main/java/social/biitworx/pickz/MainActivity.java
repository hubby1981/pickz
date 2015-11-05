package social.biitworx.pickz;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer;
public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        context = getApplicationContext();
        ComposedDrawView view = (ComposedDrawView)findViewById(R.id.view);
        if(view!=null){
            view.registerView(new BackgroundView());
            view.registerView(new MenuView());
            view.registerView(new CircleView());
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        update();
                    }
                });
            }
        },0,5000);
    }


    private void update(){
        findViewById(R.id.view).invalidate();
    }

}
