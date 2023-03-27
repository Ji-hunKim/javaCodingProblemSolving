package programmers;

import java.util.*;

class Solution {
  public String solution(String s) {
    String [] arr = s.split(" ");
    int [] num = new int[arr.length];

    for(int i=0;i<arr.length;i++){
      num[i] = Integer.parseInt(arr[i]);
    }

    Arrays.sort(num);
    return num[0] + " " + num[num.length-1];
  }
}