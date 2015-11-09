package social.biitworx.pickz;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by marcel.weissgerber on 09.11.2015.
 */
public class FileHelper {
    private static String getJSONString(Context context,String file)
    {
        String str = "";
        try
        {
            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open(file);
            InputStreamReader isr = new InputStreamReader(in);
            char [] inputBuffer = new char[100];

            int charRead;
            while((charRead = isr.read(inputBuffer))>0)
            {
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                str += readString;
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        return str;
    }

    public static JSONObject getObject(String file){
        try {
            return new JSONObject(getJSONString(MainActivity.context,file));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
