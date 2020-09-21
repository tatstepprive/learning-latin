package org.home.latin.domain;

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

}
