package org.home.latin.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String toHex(String arg)  {
        char ch[] = arg.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(Integer.toHexString((int) ch[i]));
        }
       return sb.toString();
    }

    public static int getRandomFromMax(int max){
        return (int) Math.floor(Math.random()*max);
    }

    public static String getNameTimeBased(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        Date now=new Date();
        return  format.format(now);
    }


}
