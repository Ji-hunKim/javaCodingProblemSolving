package baekjoon;

import java.util.*;
import java.io.*;

public class 수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int pt = 0;
        int base = 0;

        while (base <= 30000) {
            base++;
            String baseStr = String.valueOf(base);
            for (int i = 0; i < baseStr.length(); i++) {
                if (baseStr.charAt(i) == num.charAt(pt))
                    pt++;
                if (pt == num.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }

    }
}