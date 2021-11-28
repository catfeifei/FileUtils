package afton.utils.file;

import android.content.Context;

public class ScreenUtils {

    //获取屏幕高度px

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    //获取屏幕宽度px
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

}
