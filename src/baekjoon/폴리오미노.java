package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 폴리오미노 {
        static String str;
        static String[] strArr = {"AAAA", "BB"};
        static boolean ch;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            str = sc.next();
            int n = 0;

            List<Integer> li = new ArrayList<>();

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '.'){
                    if(n != 0){
                        if(n % 2 == 1){
                            ch = true;
                            break;
                        }
                        li.add(n);
                        n = 0;
                    }
                }else{
                    n++;
                }
            }

            if(n>=0) {
                if(n % 2 == 0){
                    li.add(n);
                }else{
                    ch = true;
                }
            }

            int idx = 0;
            boolean letterCheck = false;

            String answer = "";
            int cur = 0;



            for(int i=0; i<str.length(); i++){
                if(ch) break;

                if(str.charAt(i) == '.'){
                    answer += '.';
                    if(letterCheck){
                        idx++;
                        letterCheck = false;
                    }
                }else{
                    letterCheck = true;
                    cur = li.get(idx);
                    i += cur-1;
                    while(cur>0){
                        if(cur >= 4){
                            answer += strArr[0];
                            cur -= 4;
                        }else{
                            answer += strArr[1];
                            cur -= 2;
                        }
                    }
                }
            }

            if(ch) System.out.println(-1);
            else System.out.println(answer);
        }

    }