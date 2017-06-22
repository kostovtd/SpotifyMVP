package com.kostovtd.spotifymvp.util;
import java.util.ArrayList;

/**
 * Created by kostovtd on 22.06.17.
 */
public class Is {

    public static boolean empty(String str) {
        if(str == null || str.trim().isEmpty()) {
            return true;
        }

        return false;
    }


    public static boolean empty(String[] strArr) {
        if(strArr == null || strArr.length == 0) {
            return true;
        }

        return false;
    }


    public static boolean empty(ArrayList<String> strList) {
        if(strList == null || strList.size() == 0) {
            return true;
        }

        return false;
    }
}
