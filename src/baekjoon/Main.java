package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int xpos[]= {0,0,1,-1,1,1,-1,-1};
    static int ypos[]= {1,-1,0,0,1,-1,-1,1};
    static int[][] map;
    static int[][] dis;

    public static void main(String[] args) {
        String time1 = "12:10";
        String time2 = "9:10";
        String plus = "30";

        System.out.println(toInt(time1));
        System.out.println(timeAdd(time2, plus));

    }
    public static int toInt(String t){
        return Integer.parseInt(t.replace(":", ""));
    }

    public static String timeAdd(String t, String plus){
        int idx = t.indexOf(":");
        int h = Integer.parseInt(t.substring(0,idx));
        int m = Integer.parseInt(t.substring(idx+1));
        int p = Integer.parseInt(plus);

        if(m+p >= 60){
            h++;
            m = m-60;
        }
        if(h == 0){
            return "00" + ":" + String.valueOf(m);
        }

        return String.valueOf(h) + ":" + String.valueOf(m);
    }
}