package lizhuorui.hellomvp;

import android.app.Application;

/**
 * Created by rui on 2017/7/22.
 */

public class App extends Application{


    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static App getContext() {
        return mContext;
    }
}
