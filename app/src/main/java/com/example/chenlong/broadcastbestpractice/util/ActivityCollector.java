package com.example.chenlong.broadcastbestpractice.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenLong on 2017/1/21.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    /**
     * 添加单个activity到Activity集合
     *
     * @param activity
     */
    public static void addActicity(Activity activity)
    {
        activities.add(activity);
    }

    /**
     * 移除单个activity从Activity集合
     *
     * @param activity
     */
    public static void removeActivity(Activity activity)
    {
        activities.remove(activity);
    }

    /**
     * 循环关闭集合中的activity
     */
    public static void finishAll()
    {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
