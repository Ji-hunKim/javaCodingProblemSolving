package leetcode;

import java.util.*;


class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> li = new ArrayList<>();
        List<int[]> te = new ArrayList<>();


        for(int[] temp : intervals){
            li.add(temp);
        }


        Collections.sort(li, new Comparator<int[]>(){
            @Override
            public int compare(int[] obj1, int[] obj2){
                if(obj1[0] < obj2[0]) return -1;
                else if(obj1[0] > obj2[0]) return 1;
                else{
                    if(obj1[1] < obj2[1]) return -1;
                    else if(obj1[1] > obj2[1])  return 1;
                    else return 0;
                }
            };
        });


        int start = li.get(0)[0];
        int end = li.get(0)[1];


        int[] addArr;


        for(int i=1; i<li.size(); i++){
            int[] now = li.get(i);

            if(now[0] > end){
                addArr = new int[2];
                addArr[0] = start;
                addArr[1] = end;
                te.add(addArr);
                start = now[0];
                end = now[1];
            }else{
                end = Math.max(now[1], end);
            }


        }


        addArr = new int[2];
        addArr[0] = start;
        addArr[1] = end;
        te.add(addArr);




        int[][] answer = new int[te.size()][2];
        for(int i=0; i<te.size(); i++){
            answer[i] = te.get(i);
        }


        return answer;
    }
}
