package mx.antonioyee.pueblosmagicos.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by antonioyee on 25/02/16.
 */
public class AppController extends Application {

    private static AppController mInstance;
    private static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized AppController getInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if ( mRequestQueue == null ){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return  mRequestQueue;
    }

}
