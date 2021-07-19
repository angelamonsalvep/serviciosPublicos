package com.example.serviciospublicos.models;

import android.widget.Toast;

import com.example.serviciospublicos.MainActivity;
import com.example.serviciospublicos.R;

import java.util.ArrayList;

public class GlobalInfo {

    public static ArrayList<User>  listUsers= new ArrayList<>();
    public static User userGlobal =new User();
    public static int countUsers=0;
    public static int poss=0;

    public static boolean compareStrings(String str1, String str2) {
        if (str1.equalsIgnoreCase(str2)) {
            return true;
        } else {
            return false;
        }
    }


}
