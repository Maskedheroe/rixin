package jcydshanks.com.rixin;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by JcyDS on 2018/6/9.
 * 封装Toast弹窗函数show，调用方法Global.show();
 */

public class Global {


    public static Context gContext;


    private final static int FLAG = 1;

    public static void show(String paramString)
    {
        try
        {
            Toast.makeText(gContext, paramString, Toast.LENGTH_SHORT).show();
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }


}
